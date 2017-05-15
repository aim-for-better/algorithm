/*
*  create by zzy at 2017,5:13:29 PM
*/
public class DepthFirstSearch {

    private boolean[] marked;
    
    private int count;
    
    public DepthFirstSearch(Graph G,int s){
	
	marked=new boolean[G.V()];
	
	dfs(G,s);
    }
    private void dfs(Graph G,int v){
	
	marked[v]=true;
	for(int w: G.adj(v)){
	    
	    if(!marked[w]){
		dfs(G,w);
	    }
	}
    }
    public boolean marked(int w){
	return marked[w];
    }
    public int count(){
	return count;
    }
    
}
