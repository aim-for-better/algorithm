
public class InsertionSort {

	public static void sort(int[]a){
		
		int n=a.length;
		//
		for(int i=1;i<n;i++){
			//select the insertion index 
			int j=i-1;
			int tmp=a[i];
			for(;j>=0;j--){
				if(a[i]>=a[j]){
					break;
				}
				// move  
				a[j+1]=a[j];
			}
			a[j+1]=tmp;
			//j+1 is the insertion index
		}
		
	}
	public static void insertionsort(int[]a){
		
		int n=a.length;
		
		for(int i=1;i<n;i++){
			
			int tmp=a[i];
			int j=i-1;
			for(;j>=0;j--){
				
				if(a[i]>=a[j]){
					break;
				}
				a[j+1]=a[j];
			}
			a[j+1]=tmp;
		}
	}
	public static void main(String[] args){
		
		int[] a={1,3,4,3,7,5,6,9,8};
		sort(a);
		
		System.out.println("Bottom-up insertion sort");
		for(int j:a){
			System.out.println(j);
		}
	}
}
