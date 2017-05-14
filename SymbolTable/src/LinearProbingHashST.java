/*
*  create by zzy at 2017,9:03:42 PM
*/
public class LinearProbingHashST<Key, Value> {

    private int N;
    private int M = 16;

    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {

	keys = (Key[]) new Object[M];
	vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {

	this.M = cap;

	keys = (Key[]) new Object[M];
	vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {

	return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {

	LinearProbingHashST<Key, Value> t;

	t = new LinearProbingHashST<Key, Value>(cap);

	for (int i = 0; i < M; i++) {

	    if (keys[i] != null) {

		t.put(keys[i], vals[i]);
	    }
	}

	keys = t.keys;
	vals = t.vals;
	M = t.M;

    }

    public void put(Key key, Value val) {
	if (N >= M / 2) {
	    resize(2 * M);
	}

	int i;
	for (i = hash(key); keys[i] != null; i = (i + 1) % M) {

	    if (keys[i].equals(key)) {
		vals[i] = val;
		return;
	    }
	}

	keys[i] = key;
	vals[i] = val;
	N++;

    }

    public Value get(Key key) {

	int i;
	for (i = hash(key); keys[i] != null; i = (i + 1) % M) {

	    if (keys[i].equals(key)) {
		return vals[i];
	    }
	}
	return null;
    }

    public boolean contains(Key key) {

	return get(key) != null;
    }

    public void delete(Key key) {

	//first confirm that the hash st contains key
	if (!contains(key))
	    return;
	
	
	//find the index of key
	int i=hash(key);
	while(!key.equals(keys[i])){
	    
	    i=(i+1)%M;
	}
	
	// now the i is the key's index
	// delete key by assign keys[i]=null
	keys[i]=null;
	vals[i]=null;
	
	//reinsert element after the deleted key
	i=(i+1)%M;
	
	while(keys[i]!=null){
	    
	    Key keyToRedo=keys[i];
	    Value valToRedo=vals[i];
	    keys[i]=null;
	    vals[i]=null;
	    N--;
	    put(keyToRedo,valToRedo);
	    i=(i+1)%M;
	}
	
	//finally minus N
	N--;
	
	if(N>0&&N==M/8)
	    resize(M/2);
    }
}
