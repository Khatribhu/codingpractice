package src.java.practice.Array;

import java.util.Arrays;
import java.util.Random;

public class ReservoirProblem {

	public static void main(String[] args) {
		int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int n = stream.length;
		int k = 9;
		selectKNumber(stream, n, k);
	}

	public static void selectKNumber(int stream[], int n, int k) {
		// index of elements in streams.
		int i;

		// reservoir is the output array.Initialize it first k elements.
		int reservoir[] = new int[k];
		for (i = 0; i < k; i++) {
			reservoir[i] = stream[i];
		}

		Random r = new Random();

		// iterate k+1 to n.
		for (; i < n; i++) {

			// pick the random index from 0 to i.
			int j = r.nextInt(i + 1);

			// if randomly picked elements is smaller then k, then replace the element
			// present at the index with new element from stream.
			if(j < k) {
				reservoir[j] = stream[i];
			}
			
		}
		
		System.out.println("Following are the randomly selected elements");
		System.out.println(Arrays.toString(reservoir));

	}
}
