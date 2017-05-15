/*
*  create by zzy at 2017,9:20:29 PM
*/
public class CC {

    
    private boolean [] marked;
    private int[] id;
    private int count;
    
    public CC(Graph G){
	
	marked=new boolean[G.V()];
	
	id=new int[G.V()];
	
	for(int s=0;s<G.V();s++){
	    
	    if(!marked[s]){
		dfs(G,s);
		
		count++;
	    }
	}
	
    }
    
    public void dfs(Graph G,int s){
	
	marked[s]=true;
	id[s]=count;
	
	for(int w: G.adj(s)){
	    
	    if(!marked[w]){
		dfs(G,w);
	    }
	}
	
    }
    
    public boolean connected(int v,int w){
	return id[v]==id[w];
    }
    
    public int id(int v){
	return id[v];
    }
    public int count(){
	return count;
    }
}
