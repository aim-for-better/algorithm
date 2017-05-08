package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 10:24:06 PM
*/
public class SelectionSort {

	
	public static void sort(int[]a){
	    int n=a.length;
	    
	    for(int i=0;i<n;i++){
		int min=i;
		for(int j=i+1;j<n;j++){
		    
		    if(a[j]<a[min]){
			min=j;
		    }
		    
		}
		if(min!=i){
		    AlgorithmUtils.exch(a,i,min);
		}
	    }
	}
}
