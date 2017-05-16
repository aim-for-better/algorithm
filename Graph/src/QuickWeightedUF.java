/*
*  create by zzy at 2017,9:27:19 PM
*/
public class QuickWeightedUF {

    private int[] id;
    private int[] size;
    private int count;

    public QuickWeightedUF(int N) {

	count = N;

	id = new int[N];
	size = new int[N];
	for (int i = 0; i < N; i++) {

	    id[i] = i;
	}
	for (int i = 0; i < N; i++)
	    size[i] = 1;
    }

    public int count() {
	return count;
    }

    public boolean connected(int p, int q) {

	return find(p) == find(q);
    }

    public int find(int p) {

	while (p != id[p])
	    p = id[p];

	return p;
    }

    public void union(int p,int q){
	
	int pRoot=find(p);
	
	int qRoot=find(q);
	
	if(pRoot==qRoot) return;
	
	if(size[pRoot]<size[qRoot]){
	    
	    id[pRoot]=qRoot;
	    size[qRoot]+=size[pRoot];
	}else{
	    
	    id[qRoot]=pRoot;
	    size[pRoot]+=size[qRoot];
	}
    }
}
