package edu.upenn.cis.cis121.hw4;

public class Node<E> {
	
	private E _element;
	private Node<E> _next;
	
	/**
	 * Default constructor.
	 * @param element element parameter of the node.
	 */
	public Node(E element) {
		_element = element;
		_next = null;
	}
	
	/**
	 * Gets the element parameter of this node.
	 * @return the object that is the element parameter of this node.
	 */
	public E getElement() {
		return _element;
	}
	
	/**
	 * Returns the next parameter of this node.
	 * @return the object that is the next parameter of this node.
	 */
	public Node<E> getNext() {
		return _next;
	}
	
	/**
	 * Sets the element parameter of this node.
	 * @param element the object to be set as the element.
	 */
	public void setElement(E element) {
		_element = element;
	}
	
	/**
	 * Sets the next parameter of this node.
	 * @param next the node to be set.
	 */
	public void setNext(Node<E> next) {
		_next = next;
	}

}
