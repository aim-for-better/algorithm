package algorithm;

import algorithm.AlgorithmUtils;

/*
*  create by zzy at 2017,7:55:19 PM
*/
public class Quick3way {

    public static void sort(int[] a) {

    }

    private static void sort(int[] a, int lo, int hi) {

	if (hi <= lo)
	    return;

	int lt = lo, i = lo + 1, gt = hi;
	int v = a[lo];

	while (i < gt) {

	    // if a[i]<a[lt],exch,
	    // this will move element than less a[lo],at left
	    if (a[i] < v) {
		AlgorithmUtils.exch(a, lt++, i++);
	    } else if (a[i] > v) {

		AlgorithmUtils.exch(a, i++, gt--);
	    } else {
		i++;
	    }
	}
	sort(a, lo, lt - 1);
	sort(a, gt + 1, hi);

    }

}
