import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortComparison {
	public static int[][] createArrayOfRandomIntArrays(int numberOfArrays, int sizeOfArrays) {
		int[][] A = new int[numberOfArrays][sizeOfArrays];
		for (int i = 0; i < numberOfArrays; i++) {
			A[i] = new Random().ints(sizeOfArrays, 1, Integer.MAX_VALUE).toArray();
		}
		return A;
	}

	public static boolean sorted(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i-1] > A[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<SortingAlgorithm> sorts = new ArrayList<>();
		sorts.add(new SelectionSort());
		sorts.add(new MergeSort());
		final int RANDOM_ARRAY_SIZE = 10000;
		int[][] A = createArrayOfRandomIntArrays(sorts.size(), RANDOM_ARRAY_SIZE);

		System.out.println("To sort a random array of " + String.format("%,d", RANDOM_ARRAY_SIZE) + " ints...");
		for (int i = 0; i < sorts.size(); i++) {
			long start = System.nanoTime();
			sorts.get(i).sort(A[i]);
			long end = System.nanoTime();
			System.out.printf("%-16s", sorts.get(i).getName());
			System.out.print(" (" + (sorted(A[i]) ? "passed" : "failed") + ") took ");
			System.out.printf("%15s", String.format("%,d", end-start) + " ns\n");
		}
	}
}
