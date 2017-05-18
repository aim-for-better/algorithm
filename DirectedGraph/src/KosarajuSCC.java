/*
 *  created by zzy ,at 4:20:02 PM,May 18, 2017
*/


/**
 * 
 * justify whether the two nodes of a  Digraph is strong connected or not
 * 
 * @author zzy
 *
 */
public class KosarajuSCC {

	
	
	private boolean[] marked;
	
	private int[] id;
	private int count;
	
	
	public KosarajuSCC(Digraph G){
		
		marked=new boolean[G.V()];
		
		id=new int[G.V()];
		
		DepthFirstOrder order=new DepthFirstOrder(G.reverse());
		
		for(int s: order.reversPost()){
			
			
			if(!marked[s]){
				
				dfs(G,s);
				
				count++;
			}
		}
	}
	
	private void dfs(Digraph G ,int v){
		
		marked[v]=true;
		
		id[v]=count;
		for(int w: G.adj(v)){
			
			if(!marked[w]){
				
				dfs(G,w);
			}
		}
	}
	
	public boolean stronglyConnected(int v,int w){
		
		
		
		return id[v]==id[w];
	}
	
	public int id(int v){
		
		return id[v];
	}
	
	public int count(){
		
		return count;
	}
	
	
}

