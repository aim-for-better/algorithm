/*
*  create by zzy at 2017,7:58:47 PM
*/

import java.util.Scanner;
public class TestST {

    BinarySearchST<String ,Integer> bst=new BinarySearchST<>(10);
	Scanner in=new Scanner(System.in);
	
    
    public static void main(String[] args){
	
	BinarySearchST<String ,Integer> bst=new BinarySearchST<>(10);
	Scanner in=new Scanner(System.in);
	
	int c=0;
	while(true){
	    
	    
	    String s=in.nextLine();
	    if(s.equals("quit")) break;
	    bst.put(s, c++);
	}
	
	System.out.println(bst.size());
	bst.show();
	
	bst.delete("E");
	
	System.out.println(bst.size());
	bst.show();
    }
}
