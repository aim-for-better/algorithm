package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 2017,8:18:22 PM
*/
public class HeapSort {
    
    private static int[] arr;

    public static void sort(int[]a){
	arr=new int[a.length+1];
	
	//copy a to arr
	System.arraycopy(a, 0, arr, 1, a.length);
	int n=a.length;
	
	//first build max heap
	for(int k=n/2;k>=1;k--){
	    
	    sink(arr,k,n);
	    
	}
	
	while(n>1){
	    AlgorithmUtils.exch(arr, 1, n--);
	    sink(arr,1,n);
	}
	
    }
    
    private static void swim(int k){
	
	while(k>1&&arr[k/2]<arr[k]){

	    AlgorithmUtils.exch(arr, k, k/2);
	}
    }
    private static void sink(int[] a,int k,int n){
	
	while(2*k<=n){
	    
	 int j=2*k;
	 if(j<n&&arr[j]<arr[j+1]){
	    j++;
	 }
	 
	 if(!(arr[k]<arr[j])){
	     break;
	 }
	 
	 AlgorithmUtils.exch(arr, k, j);
	 k=j;
	}
    }
}
