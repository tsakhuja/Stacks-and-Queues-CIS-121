package edu.upenn.cis.cis121.hw4;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<String> q1;
	Queue<String> q2;
	

	@Before
	public void setUp() throws Exception {
		q1 = new Queue<String>();
		q2 = new Queue<String>();
		
		q1.offer("1");
		q1.offer("2");
		q1.offer("3");
		q1.offer("4");
	}

	@Test
	public void simpleTest() {
		assertTrue(q1.size() == 4);
		assertTrue(q2.size() == 0);
		
		assertEquals(q1.peek(), "1");
		assertEquals(q1.element(), "1");
		assertEquals(q2.peek(), null);
		
		try {
			q2.element();
			fail("No exception");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
		
		assertEquals(q1.poll(), "1");
		assertEquals(q1.peek(), "2");
		assertTrue(q1.size() == 3);
		
		assertEquals(q2.peek(), null);
		
		
	}
	
	@Test 
	public void removeTest() {
		assertEquals(q1.remove(), "1");
		assertEquals(q1.peek(), "2");
		assertTrue(q1.size() == 3);
		
		try {
			q2.remove();
			fail("No exception");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

}
