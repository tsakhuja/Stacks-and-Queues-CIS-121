package edu.upenn.cis.cis121.hw4;

import java.util.EmptyStackException;

public class Stack<E> {

	private Node<E> _top;
	private int _n;
	
	public Stack() {
		_top = null;
		_n = 0;
	}
	
	/**
	 * Pushes an item onto the top of the stack.
	 * @param o the item to be pushed.
	 * @return the o argument itself.
	 */
	public E push(E o) {
		Node<E> newTop = new Node<E>(o);
		newTop.setNext(_top);
		_top = newTop;
		_n++;
		return o;
	}
	
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return the object at the top of this stack.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public E pop() throws EmptyStackException {
		if (_top != null) {
			Node<E> oldTop = _top;
			_top = oldTop.getNext();
			_n--;
			return oldTop.getElement();
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Retrieves, but does not remove, the item at the top of this stack.
	 * @return the item at the top of this stack.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public E peek() throws EmptyStackException {
		if (_top != null) {
			return _top.getElement();
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if the stack contains NO elements; false otherwise.
	 */
	public boolean empty() {
		return (_top == null);
	}
	
	/**
	 * Returns the 1-based position where an object is on this stack. 
	 * If the object occurs as an item in this stack, this method returns 
	 * the distance from the top of the stack of the occurrence nearest the top of the stack; 
	 * the topmost item on the stack is considered to be at distance 1. 
	 * The equals method is used to compare o to the items in this stack.
	 * @param o the desired object
	 * @return the 1-based position from the top of the stack where the object is located; 
	 * the return value -1 indicates that the object is not on the stack.
	 */
	public int search(E o) {
		if (_top != null) {
			Node<E> cursor = _top;
			int count = 1;
			while (cursor != null) {
				if (cursor.getElement().equals(o)) {
					return count;
				}
				count++;
				cursor = cursor.getNext();
			}
		} 
		return -1;
	}
	
	/**
	 * Returns the number of items in the queue.
	 * @return the number of items in the queue.
	 */
	public int size() {
		return _n;
	}
	
}
