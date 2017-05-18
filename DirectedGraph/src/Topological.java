/*
*  create by zzy at 2017,11:00:36 PM
*/
public class Topological {

    
    private Iterable<Integer> order;
    
    public Topological(Digraph G){
	
	
	DirectedCycle cycleFinder=new DirectedCycle(G);
	
	if(!cycleFinder.hasCycle()){
	    
	    DepthFirstOrder dfs=new DepthFirstOrder(G);
	    
	    order=dfs.reversPost();
	}
	
    }
    public Iterable<Integer> order(){
	return order;
    }
    
    public boolean isDAG(){
	
	return  order!=null;
    }
    
    
}
