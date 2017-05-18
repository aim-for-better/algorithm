/*
 *  created by zzy ,at 4:46:29 PM,May 18, 2017
*/

/**
 * 
 * judge whether has a path from v to w in Directed Graph G;
 * @author zzy
 *
 */
public class TransitiveClosure {

	
	private DirectedDFS [] all;
	
	public TransitiveClosure(Digraph G){
		
		all=new DirectedDFS[G.V()];
		
		for(int v=0;v<G.V();v++){
			
			
			all[v]=new DirectedDFS(G,v);
		}
	}
	
	public boolean reachable(int v ,int w){
		
		return all[v].marked(w);
	}
}

