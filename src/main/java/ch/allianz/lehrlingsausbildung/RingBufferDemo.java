package ch.allianz.lehrlingsausbildung;

import ch.allianz.lehrlingsausbildung.ringbuffer.RingBuffer;

public class RingBufferDemo {

	public static void main(String[] args) {
		RingBuffer buffer = new RingBuffer();
		buffer.write(0);
		buffer.write(1);
		buffer.write(2);
		// this overwrites a value in the buffer
		buffer.write(3);
		Integer value = buffer.read();
		while (value != null) {
			System.out.println("value is: "+value.toString());
			value = buffer.read();
		}
	}

}
