
import java.math.*;
public class BottomUpMergeSort {

	private static int[]aux;
	public static void sort(int[]a){
		
		int n=a.length;
		aux=new int[n];
		
		for(int sz=1;sz<n;sz=sz+sz){
			
			for(int lo=0;lo<n-sz;lo=lo+sz+sz){
				merge(a,lo,lo+sz-1,min(lo+sz+sz-1,n-1));
			}
		}
		
	}
	public static int min(int i,int j){
		return i<j?i:j;
	}
	public static void merge(int[]a ,int lo,int mid,int hi){
		
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
			
		}
		//merge
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k]=aux[j++];
			}else if(j>hi){
				a[k]=aux[i++];
			}else if(a[i]<a[j]){
				a[k]=aux[i++];
			}else {
				a[k]=aux[j++];
			}
		}
		
	}
	
	public static void main(String[] args){
		
		int[]a={1,3,4,2,5,8,7,6,9,13,11,234,43};
		sort(a);
		for(int j:a){
			
			System.out.println(j);
		}
	}
}
