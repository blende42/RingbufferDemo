package ch.allianz.lehrlingsausbildung.ringbuffer;
/**
 * Implementation of a ringbuffer in java
 * using an array
 * 
 * @author P. Meyer 
 */
public class RingBuffer {
	final static int BUFFERSIZE=3;
	
	private int[] buffer;
	private boolean empty;
	private int readPosition;
	private int writePosition;
	
	public RingBuffer() {
		buffer = new int[BUFFERSIZE];
		empty = true;
		readPosition = 0;
		writePosition = 0;
	}
	
	/**
	 * writes a value into the buffer.
	 * writing is always possible, if the buffer is full, writing 
	 * removes the first element which could have been read.
	 * If overwriting occurs, the value which gets overwritten is written on stderr.
	 * 
	 * @param value - the value to write into the buffer
	 */
	public void write(int value) {
		if ( !empty && readPosition == writePosition) {
			System.err.println("loosing value: "+ read());
		}
		buffer[writePosition] = value;
		if( writePosition == buffer.length -1 ) {
			writePosition = 0;	
		} 
		else {
			writePosition = writePosition + 1;
		}
		empty = false;
	}
	
	/**
	 * 
	 * @return Integer or null if buffer is empty
	 */
	public Integer read() {
		if (empty) {
			return null;
		}
		Integer value = Integer.valueOf(buffer[readPosition]);
		if ( readPosition == buffer.length -1 ) {
			readPosition = 0;
		} 
		else 
		{
			readPosition = readPosition + 1;
		}
		if ( readPosition == writePosition) {
			empty = true;
		}
		return value;
	}
	
	
}
