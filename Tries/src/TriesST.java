import java.util.LinkedList;

/*
*  create by zzy at 2017,8:38:32 PM
*/
public class TriesST<Value> {

    
    
    private static int R=256;
    
    private Node root;
    
    private static class Node{
	
	private Object val;
	private Node[] next=new Node[R];
    }
    
    
    
    /**
     * put keyu-value pair into table,remove value if key is null
     * @param key
     * @param val
     */
    public void put(String key,Value val){
	
	root=put(root,key,val,0);
    }
    
    private Node put(Node x ,String key,Value val,int d){
	
	if(x==null){
	    x=new Node();
	}
	
	// update the node that match key, then return
	if(d==key.length()){
	    x.val=val;
	    return x;
	}
	char c=key.charAt(d);
	
	x.next[c]=put(x.next[c],key,val,d+1);
	
	return x;
    }
    
    /**
     * value paired with key null if key is absent
     * @param key
     * @return
     */
    public Value get(String key){
	
	Node x=get(root,key,0);
	
	if(x==null) return null;
	
	return (Value)x.val;
    }
    private Node get(Node x, String key,int d){
	
	if(x==null) return null;
	
	//if d==key.length then has search key all
	if(d==key.length()) return x;
	
	char c=key.charAt(d); //use dth key char to identify subtries
	
	return get(x.next[c],key,d+1);
    }
    
    
    
    /**
     * remove key and its value
     * @param key
     */
    public void delete(String key){
	
    }
    
    /**
     * is there a value paired with key?
     * @param key
     * @return
     */
    public boolean contains(String key){
	
	return true;
    }
    
    
    /**
     * is the table empty?
     * @return
     */
    public boolean isEmpty(){
	return size()==0;
    }
    
    /**
     * the longest key that is a prefix of s
     * @param s
     * @return
     */
    public String longestPrefixOf(String s){
	
	int len=  search(root,s,0,0);
	
	return s.substring(0,len);
    }
    
    private int search(Node x,String s ,int d,int length){
	
	if(x==null) return length;
	
	if(x.val!=null) length=d;
	if(d==s.length()) return length;
	char c=s.charAt(d);
	
	return search(x.next[c],s,d+1,length);
    }
    private void collect(Node x,String pre,LinkedList<String> q){
	
	if(x==null) return;
	
	if(x.val!=null) q.add(pre);
	
	for(char c=0;c<R;c++){
	    
	    collect(x.next[c],pre+c,q);
	}
    }
    
    /**
     * 
     * all the keys having s as a prefix
     * @param s
     * @return
     */
    public Iterable<String> keysWithPrefix(String pre){
	
	LinkedList<String>  q=new LinkedList<String>();
	
	
	collect(get(root,pre,0),pre,q);
	return q;
	
    }
    
    /**
     * all the keys in the table
     * @return
     */
    public Iterable<String> keys(){
	
	LinkedList<String> q=new LinkedList<String>();
	
	keysWithPrefix("");
	return q;
    }
    
    /**
     * 
     * all the keys that match s wehre . matches any character
     * @param s
     * @return
     */
    public Iterable<String> keysThatMatch(String pat){
	
	LinkedList<String> q=new LinkedList<String>();
	
	collect(root,"",pat,q);
	return q;
    }
    
    private  void collect(Node x,String pre,String pat,LinkedList<String> q){
	
	int d=pre.length();
	if(x==null) return;
	
	if(d==pat.length()&&x.val!=null){
	    q.add(pre);
	}
	
	if(d==pat.length()){
	    return ;
	}
	
	char next=pat.charAt(d);
	
	for(char c=0;c<R;c++){
	    
	   if(next=='.'||next=='c'){
	       collect(x.next[c],pre+c,pat,q);
	   }
	}
	
    }
    
    public void delett(String key){
	
	
	root=delete(root,key,0);
    }
    private Node delete(Node x ,String key,int d){
	
	if(x==null) return null;
	
	
	//find the node then delete the val by setting the val to null
	if(d==key.length()){
	    x.val=null;
	}else{
	    
	    char c=key.charAt(d);
	    
	    x.next[c]=delete(x.next[c],key,d+1);
	}
	
	if(x.val!=null) return x;
	
	
	//if x has some other node then return x
	for(char c=0;c<R;c++){
	    
	    if(x.next[c]!=null) return x;
	}
	
	return null;
    }
    /**
     * number of key-value pairs
     * @return
     */
    public int size(){
	
	return size(root);
    }
    
    public int size(Node x){
	
	if(x==null) return 0;
	
	int cnt=0;
	
	if(x.val!=null) cnt++;
	
	for(char c=0;c<R;c++){
	    
	    cnt+=size(x.next[c]);
	}
	
	return cnt;
    }
   
}
