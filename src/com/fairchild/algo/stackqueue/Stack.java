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

	public Object pop(Object obj) {
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