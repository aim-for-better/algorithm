package quicksort;

public class Quicksort {
	
	//quicksort core mind:
	/*
	 * 
	 * 1. partition ,return j
	 * 2. recursively  quicksort
	 * 3. exch
	 * 
	 */
	
	public static void sort(int[]a){
		sort(a,0,a.length-1);
	}
	/*
	 * the core function:
	 * the low is the index of first array element 
	 * the hi is the index of the last array element
	 * <p style="color:red;">the index start from 0</p>
	 */
	private static void sort(int[]a,int low ,int hi){
		
		if(hi<=low){
			return;
		}
		int j=partition(a,low,hi);
		sort(a,0,j-1);
		sort(a,j+1,hi);
	}
	
	/*
	 * the core function:
	 * the low is the index of first array element 
	 * the hi is the index of the last array element
	 * <p style="color:red;">the index start from 0</p>
	 */
	private static int partition(int[]a,int low ,int hi){
		
		int i=low;
		int j=hi+1;
		int v=a[low];
		while(true){
			
			while(a[++i]<v){if(i==hi) break;}
			while(a[--j]>v){if(j==low) break;}
			if(i<j){
				
				exch(a,i,j);
			}else{
				break;
			}
				
		}
		
		exch(a,low,j);
		return j;
	}
	private static void exch(int []a,int i,int j){
		
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void main(String [] args){
		
		System.out.println("Hello,WOrld");
		int[]a={1,3,4,2,4,5,9,7,8};
		sort(a);
		for(int i:a){
			System.out.println(i);
		}
		System.exit(0);
	}
}
