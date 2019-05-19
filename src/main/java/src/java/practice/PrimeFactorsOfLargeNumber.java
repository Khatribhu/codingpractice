package src.java.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to find prime factors of a number.
 * @author bkhatri3
 *
 */
public class PrimeFactorsOfLargeNumber {

	
	public static List<Integer> primeFactors(int num) {
		List<Integer> set = new ArrayList<>();
		if(num > 0) {
			
			// check if factor of 2.
			while(num % 2 == 0) {
				set.add(2);
				num = num >> 1;
			}
			
			for(int i = 3; i <= num; i += 2) {
				if(num % i == 0) {
					set.add(i);
					num /= i;
				}
			}
			
		}
		return set;
	}
	
	public static void findDistinctPrimeFactors(int num) {
		List<Integer> set = primeFactors(num);
		for(Integer val : set) {
			System.out.print(val+" ");
		}
	}
	
	public static void main(String[] args) {
		findDistinctPrimeFactors(12);
		
	}
}
