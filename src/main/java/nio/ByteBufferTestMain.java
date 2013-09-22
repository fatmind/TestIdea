package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTestMain {


	public static void main(String[] args) throws Exception {
	
		/*
		 * DirectByteBuffer
		 */
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024);
		
		/*
		 * 
		 */
		RandomAccessFile in = new RandomAccessFile("mio.txt","rw"); 
		FileChannel channel = in.getChannel();
		MappedByteBuffer mappedbuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);

	}

}
