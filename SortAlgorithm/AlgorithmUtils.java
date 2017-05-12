package algorithm;

/*
*  create by zzy at 2017,10:39:39 PM
*/
public class AlgorithmUtils {

    public static void exch(int[] a, int i, int j) {
	
	int t=a[i];
	a[i]=a[j];
	a[j]=t;
    }
    
    public static int min(int i,int j){
	return i<j?i:j;
    }
}
