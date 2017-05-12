/*
*  create by zzy at 2017,5:22:13 PM
*/



import java.lang.Comparable;

public class BinarySearchST<Key extends Comparable<Key>,Value> {

   private Key[] keys;
   private Value[] vals;
   
   //the counter to remember how many items
   private int N;
   
   private boolean isEmpty(){
       
       return size()==0;
   }
   public BinarySearchST(int capacity){
       
       keys=(Key[]) new Comparable[capacity]; 
       vals=(Value[]) new Object[capacity];
       
       
   }
   public int size(){
       return N;
   }
   public int rank(Key key){
       
       int lo=0,hi=N-1;
       while(lo<=hi){
	   
	   int mid=lo+(hi-lo)/2;
	   
	   int cmp=key.compareTo(keys[mid]);
	   if(cmp<0){
	       hi=mid-1;
	   }else if(cmp>0){
	       lo=mid+1;
	   }else {
	       return mid;
	   }
       }
       return lo;
   }
   
   public Key min(){
       return keys[0];
   }
   public Key max(){
       return keys[N-1];
   }
   
   public Key select(int k){
       
       return keys[k];
   }
   public Key ceiling(Key key){
       
      int i=rank(key);
      return keys[i];
   }
   
   public Key floor(Key key){
       
       int i=rank(key);
       if(keys[i].compareTo(key)==0)
       return keys[i];
       else 
	   return keys[i-1];
   }
   public Value get(Key key){
       
       if(isEmpty()) return null;
       
       int i=rank(key);
       if(i<N&&keys[i].compareTo(key)==0){
	   return vals[i];
       }else{
	   
	   return null;
       }
       
   }
   public void put(Key key,Value val){
       
       
       int i=rank(key);
       
       if(i<N&&keys[i].compareTo(key)==0){
	   vals[i]=val;
	   return;
       }
       for(int j=N;j>i;j--){
	   
	   keys[j]=keys[j-1];
	   vals[j]=vals[j-1];
       }
       keys[i]=key;
       vals[i]=val;
       N++;
       
   }
   public void show(){
       
       System.out.println("in show the n is:"+N+",the  kyes size is "+keys.length);
       for(int i=0;i<N;i++){
	   
	   System.out.println(keys[i]+","+vals[i]);
       }
	   
   }
   public void delete(Key key){
       
       int i=rank(key);
       
       //if search hit
       if(i<N&&keys[i].compareTo(key)==0){
	   
	   for(int j=i;j<N-1;j++){
	       keys[j]=keys[j+1];
	       vals[j]=vals[j+1];
	   }
	   N--;
	   return ;
       }else{
	   
	   return ;
       }
   }
   
  
}
