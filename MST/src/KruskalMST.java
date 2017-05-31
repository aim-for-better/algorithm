import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 *  created by zzy ,at 4:10:22 PM,May 31, 2017
*/
public class KruskalMST {

	
	private LinkedList<Edge> mst;
	
	public KruskalMST(EdgeWeightedGraph G){
		
		mst=new LinkedList<Edge>();
		
		
		UF uf=new UF(G.V());
		
	    PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
	    
	    for(Edge e: G.edges()){
	    	
	    	
	    	pq.add(e);
	    }
	    
	    
		
	    
	    while(!pq.isEmpty()&&mst.size()<G.V()-1){
	    	
	    	Edge e=pq.poll();
	    	
	    	int v =e.either();
	    	
	    	int w=e.other(v);
	    	
	    	if(uf.connected(v, w)) continue;
	    	uf.union(v, w); //this step is not must needed;
	    	
	    	mst.add(e);
	    }
	}
	
	
}

