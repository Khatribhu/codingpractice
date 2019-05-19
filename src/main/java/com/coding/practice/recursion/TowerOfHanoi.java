package com.coding.practice.recursion;

public class TowerOfHanoi {

	static int count = 0;

	public static void main(String[] args) {
		//towerOfHanoiRecur('s', 'd', 'e', 4);
		// Input: number of disks 
        int num_of_disks = 4; 
          
        TowerOfHanoi ob = new TowerOfHanoi(); 
        Stack src, dest, aux; 
          
        // Create three stacks of size 'num_of_disks' 
        // to hold the disks 
        src = ob.createStack(num_of_disks); 
        dest = ob.createStack(num_of_disks); 
        aux = ob.createStack(num_of_disks); 
          
        ob.TohIterative(num_of_disks, src, aux, dest); 
	}

	public static void towerOfHanoiRecur(char s, char d, char e, int n) {
		if (n <= 0) {
			return;
		}
		towerOfHanoiRecur(s, e, d, n - 1);
		System.out.println("Moving disk " + n + " from " + s + " to " + d);
		towerOfHanoiRecur(e, d, s, n - 1);
	}

	class Stack {
		int capacity;
		int top;
		int[] array;
	}

	// function to create stack of given capacity
	public Stack createStack(int capacity) {
		Stack stack = new Stack();
		stack.capacity = capacity;
		stack.top = -1;
		stack.array = new int[capacity];
		return stack;
	}

	boolean isFull(Stack stack) {
		return (stack.top == stack.capacity - 1);
	}

	boolean isEmpty(Stack stack) {
		return (stack.top == -1);
	}

	void push(Stack stack, int item) {
		if (isFull(stack)) {
			return;
		}
		stack.array[++stack.top] = item;
	}

	int pop(Stack stack) {
		if (isEmpty(stack)) {
			return Integer.MIN_VALUE;
		}
		return stack.array[stack.top--];
	}

	// legal movement between two poles.
	void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
		int pole1TopDisk = pop(src);
		int pole2TopDisk = pop(dest);

		// when pole 1 is empty.
		if (pole1TopDisk == Integer.MIN_VALUE) {
			push(src, pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		}

		// when pole 2 is empty.
		else if (pole2TopDisk == Integer.MIN_VALUE) {
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}

		// when top disk of pole 1 > top disk of pole 2
			else if (pole1TopDisk > pole2TopDisk) {
				push(src, pole1TopDisk);
				push(src, pole2TopDisk);
				moveDisk(d, s, pole2TopDisk);
			} else {
			push(dest, pole2TopDisk);
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}
	}

	void moveDisk(char fromPeg, char toPeg, int disk) {
		System.out.println(count%3 +" move the disk " + disk + " From " + fromPeg + " to " + toPeg);
		count++;
	}

	// function to implement TOH iterative.
	void TohIterative(int numberOfDisk, Stack src, Stack aur, Stack dest) {
		int i, totalMoves;
		char s = 's', d = 'd', a = 'a';

		// if number of disk are even interchange destination pole and aux pole.
		if (numberOfDisk % 2 == 0) {
			char temp = d;
			d = a;
			a = temp;
		}

		totalMoves = (int) (Math.pow(2, numberOfDisk) - 1);

		// largest disk will be pushed first.
		for (i = numberOfDisk; i > 0; i--) {
			push(src, i);
		}

		for (i = 1; i <= totalMoves; i++) {
			if (i % 3 == 1) {
				moveDisksBetweenTwoPoles(src, dest, s, d);
			} else if (i % 3 == 2) {
				moveDisksBetweenTwoPoles(src, aur, s, a);
			} else if (i % 3 == 0) {
				moveDisksBetweenTwoPoles(aur, dest, a, d);
			}
		}
	}
}
