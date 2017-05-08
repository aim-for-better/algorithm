package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 2017,11:14:53 PM
*/
public class MergeSort {

    
    private static int []aux;
    public static void sort(int[]a){
	
	int n=a.length;
	aux=new int[n];
	sort(a,0,n-1);
    }
    private static void sort(int[]a,int lo,int hi){
	
	if(hi<=lo) return;
	
	int mid=lo +(hi-lo)/2;
	
	sort(a,lo,mid);
	sort(a,mid+1,hi);
	merge(a,lo,mid,hi);
	
    }
    private static void merge(int []a,int lo,int mid,int hi){
	
	
	// copy a
	
	for(int k=lo;k<=hi;k++){
	    aux[k]=a[k];
	}
	// merge aux and update a
	
	int i=lo;
	int j=mid+1;
	for(int k=lo;k<=hi;k++){
	    
	    if(i>mid) a[k++]=aux[j++];
	    else if(j>hi)a[k++]=aux[i++];
	    else if(a[j]<a[i])a[k]=aux[j++];
	    else a[k++]=aux[i++];
	    
	}
    }
}
