/*
 *  created by zzy ,at 11:19:06 AM,May 12, 2017
*/
/**
 * 
 * @author zzy
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

	/**
	 * the root of the tree
	 */
	private Node root;

	private class Node {

		private Key key;
		private Value val;

		private Node left, right;

		private int N;

		public Node(Key key, Value val, int N) {

			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	/**
	 * 
	 * @return the total tree size means that the tree contains how many nodes
	 * 
	 */
	public int size() {

		return size(root);

	}

	/**
	 * 
	 * @param x
	 *            the node
	 * @return
	 */
	private int size(Node x) {

		return x.N;
	}

	/**
	 * search in the tree for key associated value
	 * 
	 * @param key
	 *            the node that key you need to search
	 * @return the associated value or null
	 */
	public Value get(Key key) {

		return get(root, key);
	}

	private Value get(Node x, Key key) {

		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.val;
		}

	}

	/**
	 * 
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {

		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {

		if (x == null) {
			return new Node(key, val, 1);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}

		return x;
	}

	/**
	 * 
	 * @return
	 */

	public Key min() {

		if (root == null)
			return null;
		else
			return min(root).key;

	}

	private Node min(Node x) {

		if (x.left == null) {

			return x;
		}

		return min(x.left);
	}

	/**
	 * 
	 * @return
	 */
	public Key max() {

		if (root == null)
			return null;

		return max(root).key;

	}

	private Node max(Node x) {

		if (x.right == null) {
			return x;
		}
		return max(x.right);
	}

	public Key floor(Key key) {

		return floor(root,key).key;
	}

	private Node floor(Node x ,Key key){
		
		if(x==null) return null;
		
		int cmp=key.compareTo(x.key);
		
		if(cmp==0) return x;
		if(cmp<0){
			return floor(x.left,key);
		}
		Node t=floor(x.right,key);
		if(t!=null)
			return t;
		else 
			return x;
	}
	
	/**
	 * 
	 * @return
	 */
	public Key ceiling(Key key) {
		return ceiling(root,key).key;

	}
	private Node ceiling(Node x,Key key){
		if (x==null) return null;
		
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp>0){
			return ceiling(x.right,key);
		}
		Node t=ceiling(x.left,key);
		if(t!=null)
			return t;
		else 
			return x;
				
	}
	

	public Key select(int k) {

		return select(root,k).key;
	}
	private Node select(Node x,int k){
		
		if(x==null) return null;
		int t=size(x.left);
		
		if(t<k) return select(x.right,k-t-1);
		else if(t>k) return select(x.left,k);
		else return x;
	}

	public int rank(Key key) {

		return rank(root,key);
	}
	private int rank(Node x,Key key){
		
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			return rank(x.left,key);
		}else if(cmp>0){
			
			return 1+size(x.left)+rank(x.right,key);
		}else{
			return size(x.left);
		}
		
	}

	/**
	 * 
	 */
	public void deleteMin() {

		
		root=deleteMin(root);
	}
	private Node deleteMin(Node x){
		
		if(x==null) return null;
		if(x.left==null) return x.right;
		
		x.left=deleteMin(x.left);
		
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void delete(Key key) {

	}
	
	private Node delete(Node x,Key key){
		
		if(x==null) return null;
		
		int cmp=key.compareTo(x.key);
		
		if(cmp<0){
			
			return delete(x.left,key);
		}else if(cmp>0){
			
			return delete(x.right,key);
		}else{
			
			// here need delte x
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			
			Node t=x;
			x=min(x.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		x.N=size(x.left)+size(x.right)+1;
		return x;
		
	}

}
