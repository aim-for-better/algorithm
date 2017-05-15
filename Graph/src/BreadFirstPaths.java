import java.util.Queue;
import java.util.Stack;

/*
*  create by zzy at 2017,8:59:17 PM
*/
public class BreadFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadFirstPaths(Graph G, int s) {

	marked = new boolean[G.V()];
	edgeTO = new int[G.V()];

	this.s = s;
	bfs(G, s);
    }

    private void bfs(Graph G, int s) {

	Queue<Integer> queue = new Queue<>();
	marked[s] = true;

	queue.add(s);
	while (!queue.isEmpty()) {

	    int v = queue.poll();

	    for (int w : G.adj(v)) {

		if (!marked[w]) {

		    queue.add(w);

		    marked[w] = true;
		    edgeTo[w] = v;
		}
	    }

	}

    }

    public boolean hasPathTo(int v) {

	return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

	if (!hasPathTo(v))
	    return null;
	Stack<Integer> path = new Stack<>();
	
	for(int x=v;x!=s;x=edgeTo[x]){
	    
	    path.push(x);
	}
	path.push(s);
	return path;

    }
}
