
public class MergeSort {

	/*
	 * 
	 * Merging: combining two ordered arrays 
	 * to make one larger ordered array
	 * This operation immediately leads to 
	 * simple recursive sort methon known as mergesort:
	 *    to sort an array, divide it into two halves,
	 *    sort the two halves(recursively), and then 
	 *    merge the results.
	 *    As you will see, one of mergesort's most attractive
	 *    properties is that it guarantees to sort any array
	 *    of N items in time proportional to NlogN.
	 *    Its prime disadvantage is that it uses extra space
	 *    proportional to N
	 *@param a the array int[]
	 */
	
	private static int[] aux;
	public static void sort(int[]a){
		
		int n=a.length;
		aux=new int[n];
		sort(a,0,n-1);
		
	}
	public static void sort(int[]a,int low,int hi){
		
		if(hi<=low){
			return;
		}
		int mid=low+ (hi-low)/2;
		
		sort(a,low,mid);
		sort(a,mid+1,hi);
		merge(a,low,mid,hi);
	}
	public static void merge(int[]a ,int low ,int mid ,int hi){
		
		//first copy from the array to the extra array aux
		
		for(int k=low;k<=hi;k++){
			aux[k]=a[k];
		}
		// second compare the element between
		int i=low;
		int j=mid+1;
		for(int k=low;k<=hi;k++){
			
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(a[i]<a[j])a[k]=aux[i++];
			else
				a[k]=aux[j++];
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
