package algorithm;
import algorithm.AlgorithmUtils;
/*
*  create by zzy at 2017,11:01:48 PM
*/
public class ShellSort {

    public static void sort(int[]a){
	
	/*
	 * shell sort is a fast algorithm 
	 * based on insertion algorithm
	 */
	
	//init n
	int n=a.length;
	int h=1;
	while(h<n/3){
	    
	    h=3*h+1;
	}
	
	while(h>=1){
	    
	    for(int i=h;i<n;i++){
		for(int j=i;j>=h&&a[j]<a[j-h];j-=h){
		    AlgorithmUtils.exch(a, j, j-h);
		}
	    }
	    h/=3;
	    
	}
    }
}
