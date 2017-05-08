package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 2017,11:23:49 PM
*/
public class QuickSort {

    
    public static void sort(int[]a){
	
	int n=a.length;
	sort(a,0,n-1);
    }
    private static void sort(int[]a,int lo,int hi){
	
	
	if(hi<=lo){
	    return;
	}
	
	int j=partition(a,lo,hi);
	sort(a,lo,j-1);
	
	sort(a,j+1,hi);
    }
    private static int partition(int[]a,int lo,int hi){
	
	int i=lo;
	int j=hi+1;
	int v=a[lo];
	
	while(true){
	    
	    while(a[++i]<v) if(i==hi) break;
	    while(a[++j]>v) if(j==lo) break;
	    if(i<j){
		AlgorithmUtils.exch(a, i, j);
	    }else{
		break;
	    }
	}
	
	AlgorithmUtils.exch(a, lo, j);
	
	return j;
    }
    
}
