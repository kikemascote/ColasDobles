package queue;

import node.node;

public interface iQueue<T> {
	void enQueue(T value) throws QueueFullException;
	T deQueue() throws QueueEmptyException;
	boolean isEmpty();
	boolean isFull();
	T front() throws QueueEmptyException;
	node<T> search(T value) throws QueueEmptyException;
	void clear();
	int size();

}
