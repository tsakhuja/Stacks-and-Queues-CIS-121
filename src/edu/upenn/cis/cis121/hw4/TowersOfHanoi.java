package edu.upenn.cis.cis121.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class TowersOfHanoi {
	private HanoiStack<Integer> left;
	private HanoiStack<Integer> mid;
	private HanoiStack<Integer> right;
	
	/**
	 * Creates a new TowersOfHanoi with the specified number of pieces. 
	 * Initially, all pieces should be in the left tower. If the input is 5, 
	 * the pieces in the game should be: 0, 1, 2, 3, 4
	 * @param numPieces the number of pieces in the game.
	 * @throws IllegalArgumentException if the numPieces is less than 1.
	 */
	public TowersOfHanoi(int numPieces) throws IllegalArgumentException {
		if (numPieces > 0) {
			left = new HanoiStack<Integer>();
			mid = new HanoiStack<Integer>();
			right = new HanoiStack<Integer>();
			// Populate left stack with appropriate number of pieces.
			for (int i = (numPieces - 1); i >= 0; i--){
				left.push(new Integer(i));
			}
		} else {
			throw new IllegalArgumentException();
		}			
	}
	
	/**
	 * Returns an ArrayList containing the three towers in the game in the order left, middle, right.
	 * @return an ArrayList containing three towers in the order left, middle, right.
	 */
	public java.util.ArrayList<HanoiStack<java.lang.Integer>> getTowers() {
		ArrayList<HanoiStack<java.lang.Integer>> out = new ArrayList<HanoiStack<java.lang.Integer>>();
		out.add(left);
		out.add(mid);
		out.add(right);
		return out;
	}
	
	/**
	 * Moves a piece from a tower to another.
	 * @param from the tower from which the piece should be removed (left = 0, middle = 1, right = 2).
	 * @param to the tower to which the removed piece is moved. (left = 0, middle = 1, right = 2).
	 * @return true if the move is made successfully; false otherwise.
	 */
	public boolean move(int from, int to) {
		HanoiStack<Integer> source = stackMap(from);
		HanoiStack<Integer> dest = stackMap(to);
		Integer itemToPush;
		// ensure validity of input
		if (source == null || dest == null) {
			return false;
		} else {
			try {
			itemToPush = source.peek();
			} catch (EmptyStackException e) {
				return false;
			}
			// try to push item to dest stack
			if (dest.push(itemToPush) != null) {
				// remove successfully pushed item form source stack
				source.pop();
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Maps integers 0, 1, 2 to left, mid, and right stacks, or null if invalid.
	 * @param i the integer to be mapped to a stack.
	 * @return stack corresponding to input; null if invalid input.
	 */
	private HanoiStack<Integer> stackMap(int i) {
		HanoiStack<Integer> stack;
		switch (i) {
		case 0: stack = left;
		break;
		case 1: stack = mid;
		break;
		case 2: stack = right;
		break;
		default: stack = null;
		break;
		}
		return stack;
	}
	/**
	 * Prints the current state of the towers. You can print horizontally (easy) or vertically (more difficult). 
	 * The requirement here is that it must be obvious what the state of the game is. 
	 * If left contains pieces [10, 6, 3] it should print something like LEFT: [10, 6, 3]
	 */
	public void printTowers() {
		StringBuffer buf = new StringBuffer();
		buf.append("LEFT   MID   RIGHT\n");
		
		Integer [] lVals = stackContents(left);
		Integer [] mVals = stackContents(mid);
		Integer [] rVals = stackContents(right);
		// Make array of the contents of all stacks.
		Integer [][] lmrVals = {lVals, mVals, rVals};

		// Create 
		for (int i = 0; i < Math.max(lVals.length, Math.max(mVals.length, rVals.length)); i++) {
			StringBuffer line = new StringBuffer();
			for (Integer[] k : lmrVals) {
				if (i < k.length) {
					line.append(k[i].toString() + "\t");
				} else {
					line.append("\t");
				}
			}
			line.append("\n");
			// Add to beginning of string buffer.
			buf.insert(0, line.toString());
		}
		buf.insert(0, "\nThe State of the Game: \n");
		System.out.println(buf);	
	}
	/**
	 * Returns the contents of a stack as an array.
	 * @param stack the stack whose whose contents to return.
	 * @return the contents of the stack as an array. Left to right = bottom to top of stack.
	 */
	private Integer[] stackContents(HanoiStack<Integer> stack) {
		Integer[] output = new Integer[stack.size()];	
		for (int i = output.length - 1 ; i >= 0; i--) {
			try {
				output[i] = stack.pop();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0 ; i < output.length; i++) {
			stack.push(output[i]);
		}
		return output;
	}
	
	/**
	 * Maps a string to its corresponding stack. If the string doesn't corresponds to a stack, returns -1.
	 * @param s the string to be mapped. Returns -1 if no mapping is found.
	 * @return
	 */
	private static int charToStackNo(String s) {
		s = s.toLowerCase();
		int out = -1;
		if (s.equals("l")) {
			out = 0;
		} else if (s.equals("m")) {
			out = 1;
		} else if (s.equals("r")) {
			out = 2;
		}
		return out;
	}
	
	/**
	 * Waits until valid user input is received and returns it as an array of ints of length 2.
	 * @return an array of valid input (2 integers: 0, 1, 2).
	 */
	private static int[] getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String failMessage = "Invalid input. You must enter only two characters from the set (l, m, r) separated" +
							"by a space.\n";
		while (true) {
			try {
				String userInput = reader.readLine();
				// Break down user input into its components.
				String[] inputArray = userInput.split(" +");
				// If the user entered more than two arguments, input is not valid.
				if (inputArray.length != 2) {
					System.out.println(failMessage);
				} else if (inputArray.length == 2) {
					int firstInt = charToStackNo(inputArray[0]);
					int secondInt = charToStackNo(inputArray[1]);
					if ( firstInt != -1 && secondInt != -1) {
						int[] out = {firstInt, secondInt};
						return out;
					} else {
						System.out.println(failMessage);
					}
				}
			} catch (IOException e) {
				System.out.println(failMessage);
			}		
		}
	}
	/**
	 * Runs the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// Verify that the user input a single integer as input to begin the game. 
		int num; 
		if (args.length != 1) {
			System.out.println("Enter a SINGLE INTEGER corresponding to the number of pieces in the game to get started.");
			return;
		} else {
			try {
				num = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Enter a SINGLE INTEGER corresponding to the number of pieces in the game to get started.");
				return;
			}
		}
		// Start a new game.
		TowersOfHanoi game = new TowersOfHanoi(num);
		ArrayList<HanoiStack<Integer>> towers = game.getTowers();
		HanoiStack<Integer> midTower = towers.get(1);
		HanoiStack<Integer> rightTower = towers.get(2);
		
		// Continue playing game while neither the middle nor the right stack have all the pieces.
		while (!(midTower.size() == num || rightTower.size() == num)) {
			System.out.println("Make your next move. Moves should be in the form l r,\n" +
					"for example, where the first character is the source stack and the second\n" +
					"character is the destination stack.l m r = Left Middle Right respectively.");
			
			game.printTowers();
			
			// Boolean that represents whether or not a valid move was made.
			boolean validMove = false;
			while (!validMove) {
				int[] moves = getInput();
				// update validMove to reflect success of attempted move.
				validMove = game.move(moves[0], moves[1]);
				if (!validMove) {
					System.out.println("Invalid move! You may only stack lower numbered pieces on higher " +
							"numbered pieces. Make another move.");
				}
			}	
		}
		game.printTowers();
		System.out.println("*************************************");
		System.out.println("*****Congratulations! You won!!!*****");
		System.out.println("*************************************");
	}
}
