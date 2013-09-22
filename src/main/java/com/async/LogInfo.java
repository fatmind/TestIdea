package com.async;

/**
 * 日志对象
 * 
 * @author shi
 */
public class LogInfo {

	private Object actor;
	private long timestamp;
	private String content;

	public LogInfo(Object actor,long timestamp, String content) {
		this.actor = actor;
		this.timestamp = timestamp;
		this.content = content;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getActor() {
		return actor;
	}

	public void setActor(Object actor) {
		this.actor = actor;
	}
	
	public String toString() {
		return "处理 -- " + this.actor.getClass() + " : " +
						   this.getTimestamp() + " : " + 
						   this.getContent();
	}

}
