interface MyQueue<T> {
	MyQueue<T> enqueue(T ele);

	T dequeue();

	boolean isEmpty();
}