/*
 *  created by zzy ,at 3:50:13 PM,May 31, 2017
*/
public class UF {

	
	private int [] id;
	
	private int [] sz;
	private int count;
	public UF(int N){
		
		count=N;
		
		id=new int[N];
		
		for(int i=0;i<N;i++){
			
			id[i]=i;
			sz[i]=1;
		}
	}
	
	public int find(int p){
		
		while(id[p]!=p){
			
			p=id[p];
		}
		return p;
	}
	public int quickFind(int p){
		
		return id[p];
		
		
	}
	
	public void slowUnion(int p,int q){
		
		int pId=find(p);
		int qId=find(q);
		
		if(pId==qId) return ;
		
		int len=id.length;
			
			for(int i=0;i<len;i++){
				
				if(id[i]==pId){
					
					id[i]=qId;
				}
			}
		
	}
	public void union(int p,int q){
		
		
		int pRoot=find(p);
		int qRoot=find(q);
		
		
		if(pRoot==qRoot) return ;
		
	     id[pRoot] =qRoot;
	     
	     if(sz[pRoot]<sz[qRoot]){
	    	 
	    	 id[pRoot]=qRoot;
	    	 sz[qRoot]+=sz[pRoot];
	     }else{
	    	 
	    	 id[qRoot]=pRoot;
	    	 
	    	 sz[pRoot]+=sz[qRoot];
	     }
	     count--;
	}
	
	public int count(){
		
		return count;
	}
	
	public boolean connected(int p,int q){
		
		return find(p)==find(q);
	}
}

