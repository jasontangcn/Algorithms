package com.fairchild.algo.stackqueue;

public class Queue {
	private int capacity;
	private Object[] data;
	private int head, tail;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
	}
	
	public boolean enqueue(Object obj) {
		if(isFull()) return false;
		data[tail] = obj;
		tail = (tail + 1)%capacity;
		return true;
	}
	
	public Object dequeue() {
		if(isEmpty()) return null;
		Object obj = data[head];
		head = (head + 1)%capacity;
		return obj;
	}
	
	public boolean isFull() {
		if((tail + 1)%capacity == head)
			return true;
		return false;
	}
	
	public boolean isEmpty() {
		return (head == tail);
	}
}
