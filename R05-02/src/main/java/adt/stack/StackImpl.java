package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (isEmpty() == true) {
			return null;
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == array.length-1){
			return true;
		}
		return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		}
		top ++;
		array[top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty() == true) {
			throw new StackUnderflowException();
		}
		T e;
		e = array[top];
		top --;

		return e;
	}

}
