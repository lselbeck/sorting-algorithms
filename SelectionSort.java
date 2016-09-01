// O(n^2) runtime, O(1) memory

public class SelectionSort implements SortingAlgorithm {
	private String name = "Selection Sort";
	public String getName() { return name;	}

	public void sort(int[] A) {
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
}