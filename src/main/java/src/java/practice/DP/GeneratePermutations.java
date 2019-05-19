package src.java.practice.DP;

import java.util.List;

/**
 * Program to generate all permutations of string.
 * @author bkhatri3
 *
 */
public class GeneratePermutations {

	public static void main(String[] args) {
		
	}
	
	public static String permutations(String str, List<String> list) {
		
		if(str.length() == 1) {
			return str;
		}
		return "";
	}
}
