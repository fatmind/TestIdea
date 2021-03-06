package com.temp.sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.LinkedList;

final public class Sort {

	private static Sort instance = null;
	private int numberOfWords = 0;
	private String[] words;

	public static void main(String[] args) {

//		if (args.length != 3) {
//			args = new String[3];
//			args[0] = "16";
//			args[1] = "sowpods.txt";
//			args[2] = "out.txt";
//		}

		int threadCount = 16;
		Sort sort = Sort.getInstance();
		Date start = new Date();

		if (!sort.getWordsFromInput("D:/Temp/sort/sowpods.txt")) {
			System.out.println("Could not retrieve words from " + args[1] + "!");
			return;
		}

		if (!sort.sortWords(threadCount)) {
			System.out.println("Something went wrong when sorting the words!");
			return;
		}

		if (!sort.writeWordsToOutput("D:/Temp/sort/tielun_sort.txt")) {
			System.out.println("Could not write sorted words to " + args[2]);
			return;
		}

		Date end = new Date();
		long timeToComplete = end.getTime() - start.getTime();

		System.out.println("Using " + threadCount + " threads, "
				+ sort.getWords().length + " words was sorted in "
				+ timeToComplete + " milliseconds.");
	}

	
	private Sort() {
	}

	
	private static Sort getInstance() {
		if (instance == null) {
			instance = new Sort();
		}
		return instance;
	}
	

	public boolean getWordsFromInput(String inputFile) {
		
		System.out.print("Loading contents of " + inputFile + "... ");
		Date start = new Date();

		StringBuilder firstLine = new StringBuilder();
		StringBuilder lines = new StringBuilder(200);

		try {
			int bufferSize = 200 * 1024;
			ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
			FileInputStream in = new FileInputStream(inputFile);
			FileChannel channel = in.getChannel();
			byte[] bytes = new byte[buffer.capacity()];
			boolean readFirstLine = false;
			int word_num = 0;
			while (channel.read(buffer) != -1) {
				buffer.flip();
				int len = buffer.remaining();
				buffer.get(bytes, 0, len);
				int index = 0;
				// 首行读取单词数
				if (!readFirstLine) {
					for (int i = 0; i < len; i++) {
						char readChar = (char) bytes[i];
						if (readChar == '\r') { // ignorer \r tegn
						} else {
							if (readChar == '\n') {
								readFirstLine = true;
								index = i + 1;
								// 已经知道多少行了
								words = new String[Integer.parseInt(firstLine
										.toString())];
								break;
							}
							firstLine.append(readChar);
						}
					}
				}
				for (int i = index; i < len; i++) {
					char readChar = (char) bytes[i];
					if (readChar == '\r') {
					} else if (readChar == '\n') {
						words[word_num] = lines.toString();
						lines.setLength(0);
						word_num++;
					} else {
						lines.append(readChar);
					}

				}

				buffer.clear();
			}
		} catch (IOException e) {
			return false;
		}

		numberOfWords = words.length;
		Date end = new Date();
		long timeDiff = end.getTime() - start.getTime();

		System.out.println(timeDiff + "ms");

		return true;
	}

	public boolean writeWordsToOutput(String outputFile) {
		System.out.print("Writing results to " + outputFile + "... ");
		Date start = new Date();

		if (words.length != numberOfWords) { 
			System.out.println("Sorted list does not contain expected number of words!");
			return false;
		}

		try {
			int bufferSize = 400 * 1024;
			File file = new File(outputFile);
			if (!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}
			RandomAccessFile out = new RandomAccessFile(outputFile, "rw");// 指定目标文件
			FileChannel channel = out.getChannel(); // 从文件中获取一个通道
			ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize + 200);
			StringBuffer buf = new StringBuffer();
			int index = 0;
			for (int i = 0; i < words.length; i++) {
				// String outputWord = (i == words.length - 1) ? words[i]
				// : words[i] + "\n";
				buf.append(words[i]);
				if (buf.length() >= bufferSize) {
					buffer = channel.map(FileChannel.MapMode.READ_WRITE, index,
							buf.length());
					buffer.put(buf.toString().getBytes());
					index = index + buf.length();
					buf.setLength(0);
					buffer.clear();
				}
			}
			buffer = channel.map(FileChannel.MapMode.READ_WRITE, index,
					buf.length());
			buffer.put(buf.toString().getBytes());
			channel.close();
			buffer.clear();

			// FileOutputStream output = new FileOutputStream(outputFile);
			// BufferedOutputStream bw = new BufferedOutputStream(output);
			// for (int i = 0; i < words.length; i++) {
			// String outputWord = (i == words.length - 1) ? words[i]
			// : words[i] + "\n";
			// bw.write(outputWord.getBytes());
			// }
			// bw.flush();
			// output.flush();
			// bw.close();
			// output.close();

		} catch (IOException e) {
			return false;
		}

		Date end = new Date();
		long timeDiff = end.getTime() - start.getTime();
		System.out.println(timeDiff + "ms");

		return true;
	}

	public boolean sortWords(int threadCount) {
		System.out.print("Sorting... ");
		Date start = new Date();

		LinkedList<WordHandler> wordHandlers = new LinkedList<WordHandler>();

		initSortThreads(threadCount, wordHandlers); // Start sortering
		boolean sortResult = interleaveThreads(wordHandlers); // Flett sammen

		Date end = new Date();
		long timeDiff = end.getTime() - start.getTime();
		System.out.println(timeDiff + "ms");

		return sortResult;
	}

	private void initSortThreads(int threadCount,
			LinkedList<WordHandler> wordHandlers) {
		int wordsPerThread = words.length / threadCount;
		int additionalWordsPerThread = words.length % threadCount;

		int currentOffset = 0;

		for (int i = 0; i < threadCount; i++) {
			int wordsForThread = wordsPerThread;

			if (additionalWordsPerThread > 0) {
				wordsForThread++;
				additionalWordsPerThread--;
			}

			WordSorter sorter = new WordSorter(words, currentOffset,
					currentOffset + wordsForThread);
			wordHandlers.add(sorter);

			currentOffset += wordsForThread;
		}
	}

	private boolean interleaveThreads(LinkedList<WordHandler> wordHandlers) {
		WordHandler buffer = null;

		while (wordHandlers.size() > 0) {
			try {
				wordHandlers.peek().join();

				if (buffer == null && wordHandlers.size() == 1) {
					words = wordHandlers.poll().getWords();
				} else if (buffer == null) {
					buffer = wordHandlers.poll();
				} else {
					Interleaver merge = new Interleaver(buffer.getWords(),
							wordHandlers.poll().getWords());
					wordHandlers.add(merge);
					buffer = null;
				}
			} catch (InterruptedException e) {
				System.out.println("Main sort thread was interupted!");
				return false;
			}
		}

		return true;
	}

	public String[] getWords() {
		return words;
	}
}