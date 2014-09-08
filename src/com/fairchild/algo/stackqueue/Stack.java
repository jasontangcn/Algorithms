package com.fairchild.algo.stackqueue;

public class Stack {
	private int capacity;
	private int size;
	private Object[] data;

	public Stack(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
	}

	public boolean push(Object obj) {
		if (isFull())
			return false;
		data[size++] = obj;
		return true;
	}

	public Object peek() {
		if (isEmpty())
			return null;
		return data[size - 1];
	}
	
	public Object pop() {
		if (isEmpty())
			return null;
		--size;
		return data[size];
	}

	private boolean isFull() {
		return (size == capacity);
	}

	private boolean isEmpty() {
		return (size == 0);
	}
}