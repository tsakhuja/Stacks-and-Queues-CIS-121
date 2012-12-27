package edu.upenn.cis.cis121.hw4;

import java.util.EmptyStackException;

public class HanoiStack<E extends java.lang.Comparable<E>> extends Stack<E> {
	
	public HanoiStack() {
		super();
	}
	
	
	/**
	 * Pushes an item onto the top of this stack if and only if the item is "strictly less than" 
	 * the item on top of the stack (based on the item's compareTo() method).
	 * @return the item argument itself on success; null otherwise. 
	 * @param item the item to be pushed onto the stack.
	 */
	@Override
	public E push(E item) {
		E top;
		try {
			top = this.peek();
		} catch (EmptyStackException e) {
			super.push(item);
			return item;
		}
		// Determine if item is less than top of stack.
		if (item.compareTo(top) < 0) {
			super.push(item);
			return item;
		} else {
			return null;
		}
	}
}
