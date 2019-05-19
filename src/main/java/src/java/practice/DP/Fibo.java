package src.java.practice.DP;

public class Fibo {

	public static int[] fiboDP(int n ) {
		int[] fibResult = new int[n];
		fibResult[0] = 0;
		fibResult[1] = 1;
		
		for(int i = 2; i < n; i++) {
			fibResult[i] = fibResult[i-1] + fibResult[i-2];
		}
		
		return fibResult;
		
	}
	public static void main(String[] args) {
		int[] result = fiboDP(5);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+",");
		}
	}
}
