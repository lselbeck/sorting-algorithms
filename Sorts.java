import java.util.Arrays;
import java.util.Random;

public class Sorts {

	// O(n^2) runtime, O(1) memory
	public static void selectionSort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = i; j < A.length; j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
				}
			}
			int tmp = A[i];
			A[i] = min;
			A[minIndex] = tmp;
		}
	}

	//O(n * log n) runtime, O(n) memory
	public static void mergeSort(int[] A) {
		splitMerge(A, 0, A.length);
	}

	public static void main(String[] args) {
		int[] A = new Random().ints(100, 0, 99).toArray();
		System.out.println("Selection before: " + Arrays.toString(A));
		selectionSort(A);
		System.out.println("Selection after : " + Arrays.toString(A));
	}
}