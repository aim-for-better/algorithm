
public class ShellSort {
/*
 * the shell sort is the special insertion sort
 * is a fast algorithm based on insertion sort
 * the shell sort is a simple extension of insertion sort
 * than gains speed by allowing exchanges of array entries
 * that are far apart, to produce partially sorted array
 * that can be efficiently sorted, eventually by insertion sort;
 */
	
	public static void sort(int[]a){
		
		int n=a.length;
		
		//first get the max h
		int h=1;
		while(h<n/3){
			h=3*h+1;  //1,4,13,40,121,364,1093...
		}
		while(h>=1){
			//h-sort the array
			for(int i=h;i<n;i+=h){
				
				for(int j=i;j>=h&&a[j]<a[j-h];j-=h){
					exch(a,j,j-h);
				}
			}
			h=h/3;
		}
	}
	
	public static void exch(int[]a,int i,int j){
		
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void main(String[] args){
		
		int [] a={1,3,2,5,6,4,7,9,8,34,43,56,326,22,11,12};
		
		sort(a);
		for(int j:a){
			System.out.println(j);
		}
		
	}
	
}
