package edu.upenn.cis.cis121.hw4;

import java.util.NoSuchElementException;

public class Queue<E> {
	
	/*
	 *  Invariant: _head or _tail must both be null or _head points to
	 *  node whose next pointers form a path to the _tail node. 
	 */
	private Node<E> _head;
	private Node<E> _tail;
	
	public Queue() {
		_head = null;
		_tail = null;
	}
	
	/**
	 * Retrieves, but does not remove, the first element in the queue.
	 * @return the head of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E element() throws NoSuchElementException {
		// return element of head if not null
		if (_head != null) {
			return _head.getElement();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Inserts an element as the tail of the queue, if possible.
	 * @param o The element to be added.
	 * @return true if the insertion was successful and false otherwise.
	 */
	public boolean offer(E o) {
		Node<E> newNode = new Node<E>(o);
		// Determine whether head *and* tail should be updated or just tail.
		if (_tail != null) {
			// set node of current tail
			_tail.setNext(newNode);
			_tail = newNode;
		} else {
			_head = newNode;
			_tail = newNode;
		}
		return true;
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if this queue is empty.
	 * @return the head of the queue, or null if the queue is empty.
	 */
	public E peek() {
		if (_head != null) {
			return _head.getElement();
		} else {
			return null;
		}
	}
	
	/**
	 * Retrieves and removes the head of this queue, or null if the queue is empty.
	 * @return the head of the queue or null if it is empty.
	 */
	public E poll() {
		if (_head == null) {
			return null;
		}
		Node<E> oldHead = _head;
		// update tail to null if queue is 1 element long before removal
		if (_head == _tail) {
			_tail = null;
		} 
		_head = oldHead.getNext();
		return oldHead.getElement();
	}
	
	/**
	 * Retrieves and removes the head of this queue.
	 * @return the head of the queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E remove() throws NoSuchElementException {
		if (_head != null) {
			return this.poll();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Returns the number of items in the queue.
	 * @return the number of items in the queue.
	 */
	public int size() {
		if (_head == null) {
			return 0;
		} else{
			Node<E> cursor = _head;
			int count = 0;
			while (cursor != null) {
				count ++;
				cursor = cursor.getNext();
			}
			return count;
		}
	}

}
