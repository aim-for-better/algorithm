/*
 *  created by zzy ,at 5:04:58 PM,May 31, 2017
*/
public class DirectedEdge {

	
	private final int v;
	private final int w;
	private final double weight;
	
	public DirectedEdge(int v,int w,double weight){
		
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	
	public int from(){
		return v;
	}
	public int to(){
		
		return w;
	}
	public double weight(){
		
		return weight;
	}
	
	public String toString(){
		
		
		return String.format("%d-->%d %.2f", v,w,weight);
	}
}
