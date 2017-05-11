/*
*  create by zzy at 2017,8:29:05 PM
*/


public class RedBlackTree {

    
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private class Node{
	
	String key;
	int value;
	
	Node left,right;
	int N;
	boolean color;
	
	public Node(String key,int val,int N,boolean color){
	    
	    this.key=key;
	    this.value=val;
	    this.N=N;
	    this.color=color;
	}
    }
    
    private boolean isRed(Node x){
	if(x==null) return false;
	return x.color==RED; 
    }
    
    private int size(Node x){
	if (x==null) return 0;
	else return x.N;
    }
    private Node rotateLeft(Node h){
	
	Node x=h.right;
	h.right=x.left;
	x.left=h;
	x.color=h.color;
	h.color=RED;
	x.N=h.N;
	h.N=1+size(h.left)
	     +size(h.right);
		
	return x;
    }
    private Node rotateRight(Node h){
	Node x=h.left;
	h.left=x.right;
	x.right=h;
	x.color=h.color;
	h.color=RED;
	x.N=h.N;
	h.N=1+size(h.left)+size(h.right);
	return x;
    }
    
    private void flipColors(Node h){
	h.color=RED;
	h.left.color=BLACK;
	h.right.color=BLACK;
    }
    
    private Node root;
    
    public void put(String key,int val){
	root=put(root,key,val);
	root.color=BLACK;
    }
    public Node get(){
	return root;
    }
    public void show(){
	
	
	if(root==null) return ;
	
	show(root);
    }
    private void show(Node x){
	
	if(x==null) return;
	if(x.left!=null) show(x.left);
	System.out.println(x.key);
	
	if(x.right!=null) show(x.right);
	
    }
    private Node put(Node h,String key,int val){
	if(h==null){
	    
	    return new Node(key,val,1,RED);
	}
	
	int cmp=key.compareTo(h.key);
	
	if(cmp<0) h.left=put(h.left,key,val);
	else if(cmp>0)  h.right=put(h.right,key,val);
	else h.value=val;
	
	//modify or reshape the balanced search tree bst
	
	if(!isRed(h.left)&&isRed(h.right))  h=rotateLeft(h);
	
	if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
	
	if(isRed(h.left)&&isRed(h.right))  flipColors(h);
	
	
	h.N=size(h.left)+size(h.right)+1;
	
	return h;
	
	
    }
    
    
    
}

