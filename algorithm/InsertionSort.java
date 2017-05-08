package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 2017,10:45:08 PM
*/
public class InsertionSort {

    public static void sort(int[]a){
	
	int n=a.length;
	
	for(int i=1;i<n;i++){
	    
	    for(int j=i;j>0&&a[j]<a[j-1];j--){
		
		AlgorithmUtils.exch(a, j, j-1);
	    }
	}
    }
}
