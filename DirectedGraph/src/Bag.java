import java.util.Iterator;

/*
*  create by zzy at 2017,3:53:38 PM
*/
public class Bag<Value> implements Iterable<Value>{

    
    private Value[] vals;
    private int count;
    private int c;
    public Bag(){
	
	
    }
    public Bag(int n){
	
	vals=(Value[]) new Object[n];
	
    }
    
    public void add(Value val){
	
	vals[count++]=val;
    }
    public Value pop(){
	
	
	
	
	count--;
	return vals[count];
    }
    public int size(){
	
	return count;
    }
    @Override
    public Iterator<Value> iterator() {
	// TODO Auto-generated method stub

	 
	 Value[] v=this.vals;
	 int total=this.count;
	
	
	 class Iter implements Iterator<Value>{
 
	     
	     
	    @Override
	    public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return count>0;
		
	    }

	    @Override
	    public Value next() {
		// TODO Auto-generated method stub
		
		return v[count--];
	    }
	    
	}
	return new Iter();
	    
	    
    }
    
}
