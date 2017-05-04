
public class SelectionSort {
	
	
	
	public static void sort(int []a){
		
		
		int n=a.length;
		for(int i=0;i<n;i++){
		
			int t=i;
			
			for(int j=i+1;j<n;j++){
				
				if(a[j]<a[t]){
					t=j;
				}
			}
			exch(a,i,t);
		}
		
	}
	
	private static void exch(int[]a,int i,int j){
		
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void main(String[] args){
		
		int []a ={1,3,2,5,6,8,4,9,7};
		sort(a);
		for(int i:a){
			System.out.println(i);
		}
	}
}
