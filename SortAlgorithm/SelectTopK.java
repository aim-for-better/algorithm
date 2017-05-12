package algorithm;

import algorithm.AlgorithmUtils;

/*
*  create by zzy at 2017,9:01:17 PM
*/
public class SelectTopK {

    /*
     * select the top k larger
     */
    public static int select(int[] a, int k) {

	int lo = 0;
	int hi = a.length - 1;

	while (hi > lo) {

	    int j = partition(a, lo, hi);

	    if (j == k) {
		return a[k];
	    } else if (j < k) {
		lo = j + 1;
	    } else if (j > k) {
		hi = j - 1;
	    }
	}
	return a[k];
    }

    private static int partition(int[] a, int lo, int hi) {

	int v = a[lo];
	int i = lo;
	int j = hi + 1;

	while (true) {

	    while (a[++i] < v)
		if (i == hi)
		    break;
	    while (a[--j] > v)
		if (j == lo)
		    break;

	    if (i < j) {

		AlgorithmUtils.exch(a, i, j);
	    } else {

		break;
	    }

	}
	AlgorithmUtils.exch(a, lo, j);

	return j;
    }

}
