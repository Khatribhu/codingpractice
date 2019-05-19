package src.java.practice.Array;

/**
 * Class to check if given number permutation makes number which is power of 2.
 * 
 * @author bkhatri3
 *
 */
public class CheckPermuationAsPowerOf2 {

	public static void main(String[] args) {
		System.out.println(reorderedPowerOf2(15
		));
		//System.out.println(Integer.toBinaryString(15));
	}

	/**
	 * reordering a number 
	 */
	public static boolean reorderedPowerOf2(int N) {
		String str = Integer.toBinaryString((Integer)N);
		
		long c = counter(N);
		for (int i = 0; i < 32; i++)
			if (counter(1 << i) == c)
				return true;
		return false;
	}

	/**
	 *  
	 */
	public static long counter(int N) {
		long res = 0;
		for (; N > 0; N /= 10)
			res += (int) Math.pow(10, N % 10);
		return res;
	}

}
