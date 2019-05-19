package com.coding.practice.OperatingSystem;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * We can use Java inbuilt deque as to store the cache keys in decending order
 * of their last accessed time. and set container to check presence of key. but
 * remove() in deque takes O(n) time which can be optimize.
 * 
 * @author bkhatri3
 *
 */
public class LRUCache {

	// store the keys of cache.
	static Deque<Integer> dq;

	// store the reference of key in cache
	static HashSet<Integer> hashSet;

	static int cSize;

	public LRUCache(int n) {
		dq = new LinkedList<>();
		hashSet = new HashSet<>();
		cSize = n;
	}

	// refer key x within LRU cache
	public void refer(int x) {
		if (!hashSet.contains(x)) {
			if (dq.size() == cSize) {
				int last = dq.removeLast();
				hashSet.remove(last);
			}
		} else {
			// the found page may not be always last element, even if it's an intermediate
			// element that needs to be removed and added to the start of the queue.
			int index = 0, i = 0;
			Iterator<Integer> itr = dq.iterator();
			while (itr.hasNext()) {
				if (itr.next() == x) {
					index = i;
					break;
				}
				i++;
			}
			dq.remove(index);
		}
		dq.push(x);
		hashSet.add(x);
	}

	public void display() {
		Iterator<Integer> itr = dq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
	}

	public static void main(String[] args) {
		
		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();
	}
}
