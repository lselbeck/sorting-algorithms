import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
	private String name = "Merge Sort";
	public String getName() { return name;	}

	//O(n * log n) runtime, O(n) memory
	public void sort(int[] A) {
		mergeSort(A, 0, A.length);
	}

	private void mergeSort(int[]A, int lo, int hi) {
		if (lo >= hi-1) return;
		int mid = (lo+hi)/2;
		mergeSort(A, lo, mid);
		mergeSort(A, mid, hi);
		merge(A, lo, mid, hi);
	}

	private void merge(int[] A, int lo, int mid, int hi) {
		int[] left  = Arrays.copyOfRange(A, lo, mid);
		int[] right = Arrays.copyOfRange(A, mid, hi);
		int lIndex = 0, rIndex = 0;
		for (int aIndex = lo; aIndex < hi; aIndex++) {
			if (rIndex == right.length) {
				A[aIndex] = left[lIndex++];
			} else if (lIndex == left.length || left[lIndex] > right[rIndex]) {
				A[aIndex] = right[rIndex++];
			} else {
				A[aIndex] = left[lIndex++];
			}
		}
	}
}