import java.util.PriorityQueue;

/*
 *  created by zzy ,at 5:21:43 PM,May 31, 2017
*/
public class DijkstraSP {

	
	
	private DirectedEdge[]  edgeTo;
	
	private double[]  distTo;
	
	private PriorityQueue<Double> pq;  // rewrite the comparator based on the weight DirectedWeight
	
	public DijkstraSP(EdgeWeightedDigraph G ,int s){
		
		
		edgeTo=new DirectedEdge[G.V()];
		
		distTo=new double[G.V()];
		
		pq=new PriorityQueue<Double>();

	}
	
	
}

