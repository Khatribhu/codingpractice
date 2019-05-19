package src.java.practice.sorting;

public class PrintSubSetOfGivenArray {
	static int[] arr = new int[100];
	static String set = "khatri";

	public static void main(String[] args) {
		int n = set.length();
		toBin(0, n);
	}

	/**
	 * @param i
	 * @param n
	 */
	private static void toBin(int i, int n) {
		
		if (i == n) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j]);
			}
			System.out.print("\t->{");
			for (int j = 0; j < n; j++) {
				if (arr[j] == 1) {
					System.out.print("" + set.charAt(j));
				}
			}
			
			System.out.println("}");
			return;
		}
		arr[i] = 0;
		toBin(i + 1, n);
		arr[i] = 1;
		toBin(i + 1, n);

	}
}