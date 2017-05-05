
public class QuikSort {

	/*
	 * QuickSort is a divide-and-conquer method for sorting it work by
	 * partitioning an array into two subarrays,then sorting the subarrays
	 * independently
	 *
	 * quicksort better need to shuffle
	 * 
	 */

	public static void sort(int[] a) {

		int n = a.length;
		sort(a, 0, n - 1);
	}

	public static void sort(int[] a, int lo, int hi) {

		if (hi <= lo) {
			return;
		}

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);

	}

	private static int partition(int[] a, int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		int v = a[lo];

		while (true) {

			while (a[++i] < v)
				if (i == hi)
					break;
			while (a[--j] > v)
				if (j ==lo)
					break;
			if (i < j) {
				exch(a, i, j);
			} else {
				break;
			}

		}
		exch(a, lo, j);

		return j;
	}

	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {

		int[] a = { 1, 3, 4, 2, 5, 8, 7, 6, 9, 13, 11, 234, 43 };
		sort(a);
		System.out.println("Quicksort");
		for (int j : a) {

			System.out.println(j);
		}
	}
}
