import java.io.InputStream;
import java.util.Scanner;

/*
*  create by zzy at 2017,3:52:33 PM
*/
public class Graph {

    
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    
    
    
    public Graph(int v){
	this.V=v;
	this.E=0;
	adj=(Bag<Integer>[]) new Bag[v];
	
	for(int i=0;i<V;i++){
	    
	    adj[v]=new Bag<Integer>();
	    
	}
    }
    
    public Graph(Scanner in){
	this(in.nextInt());
	
	int e=in.nextInt();
	for(int i=0;i<e;i++){
	    
	    int v=in.nextInt();
	    int w=in.nextInt();
	    addEdge(v,w);
	}
    }
    
    public int V(){
	
	return V;
    }
    public int E(){
	return E;
    }
    public void addEdge(int v,int w){
	
	adj[v].add(w);
	adj[w].add(v);
	E++;
    }
    public Iterable<Integer> adj(int v){
	
	return adj[v];
    }
    public static int degree(Graph G,int v){
	
	int degree=0;
	
	for(int w:G.adj(v)){
	    degree++;
	}
	return degree;
    }
    public static int maxDegree(Graph G){
	int max=0;
	for(int v=0;v<G.V();v++){
	    
	    int tmp=degree(G,v);
	    if(tmp>max){
		max=tmp;
	    }
	}
	  return max;
    }
    public static int avgDegree(Graph G){
	
	return 2*G.E()/G.V();
    }
    public static int numberOfSelfLoops(Graph G){
	
	int count=0;
	for(int v=0;v<G.V();v++){
	    for(int w: G.adj(v)){
		if(v==w)
		    count++;
	    }
	}
	return count/2;
    }
    public String toString(){
	
	String s=V +"vertices, "+E+" edges \n";
	
	for(int v=0;v<V;v++){
	    s+=v +": ";
	    for(int w:this.adj(v)){
		s+=w+" ";
	    }
	    s+="\n";
	}
	return s;
    }
}
