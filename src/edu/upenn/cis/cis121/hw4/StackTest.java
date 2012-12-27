package edu.upenn.cis.cis121.hw4;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stack<String> q1;
	Stack<String> q2;
		
	@Before
	public void setUp() throws Exception {
		q1 = new Stack<String>();
		q2 = new Stack<String>();
		
		q1.push("1");
		q1.push("2");
		q1.push("3");
		q1.push("4");
		
	}

	@Test
	public void testPush() {
		assertTrue(q2.empty());
		assertTrue(q2.size() == 0);
		assertEquals(q1.push("5"), "5");
		assertEquals(q2.push("1"), "1");
		assertTrue(q1.size() == 5);
		assertTrue(q2.size() == 1);
		
		assertFalse(q2.empty());
		assertEquals(q1.peek(), "5");
		assertEquals(q2.peek(), "1");
		
		assertEquals(q1.pop(), "5");
		assertEquals(q2.pop(), "1");
		assertTrue(q1.size() == 4);
		assertTrue(q2.size() == 0);
		
		try {
			q2.pop();
			fail("No exception thrown");
		} catch(EmptyStackException e) {
			assertTrue(true);
		}
		
		try {
			q2.peek();
			fail("No exception thrown");
		} catch(EmptyStackException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testSearch() {
		assertTrue(q1.search("3") == 2);
		assertTrue(q1.search("7") == -1);
		assertTrue(q2.search("0") == -1);
		//DO MORE SEARCH TESTS
	}

}
