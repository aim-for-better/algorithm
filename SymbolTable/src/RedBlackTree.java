
/*
 *  created by zzy ,at 3:27:27 PM,May 12, 2017
*/

import java.lang.Comparable;

import org.w3c.dom.Node;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {

	private Key key;
	private Value val;
	private Node left, right;
	private int N;
	boolean color;

	public Node(Key key, Value val, int N, boolean color) {

	    this.key = key;
	    this.val = val;
	    this.N = N;
	    this.color = color;
	}
    }

    private int size() {

	return size(root);
    }

    private int size(Node h) {

	if (h == null)
	    return 0;
	return h.N;
    }

    private boolean isRed(Node h) {

	return h.color == RED;
    }

    private Node rotateLeft(Node h) {

	Node x = h.right;
	h.right = x.left;
	x.left = h;
	x.color = h.color;
	x.N = h.N;
	h.color = RED;
	h.N = size(h.left) + size(h.right) + 1;

	return x;
    }

    private Node rotateRight(Node h) {

	Node x = h.left;
	h.left = x.right;
	x.right = h;
	x.color = h.color;
	h.color = RED;
	x.N = h.N;
	h.N = size(h.left) + size(h.right) + 1;

	return x;
    }

    private void flipColors(Node h) {

	h.left.color = BLACK;
	h.right.color = BLACK;
	h.color = RED;
    }

    private Node put(Node h, Key key, Value val) {

	if (h == null)
	    return new Node(key, val, 1, RED);

	int cmp = key.compareTo(h.key);

	if (cmp < 0) {
	    h.left = put(h.left, key, val);
	} else if (cmp > 0) {

	    h.right = put(h.right, key, val);
	} else {

	    h.val = val;

	}
	/*
	 * change the tree to make sure is red black tree this means that the
	 * red link is the left, one node only can have no more than one red
	 * link the root is black
	 */
	if (isRed(h.right) && !isRed(h.left))
	    h = rotateLeft(h);
	if (isRed(h.left) && isRed(h.left.left))
	    h = rotateRight(h);
	if (isRed(h.left) && isRed(h.right))
	    flipColors(h);

	h.N = size(h.left) + size(h.right) + 1;

	return h;
    }

    public void put(Key key, Value val) {

	root = put(root, key, val);
	root.color = BLACK;
    }

    private Node moveRedLeft(Node h) {

	flipColors(h);
	if (isRed(h.right.left)) {

	    h.right = rotateRight(h.right);
	    h.left = rotateLeft(h);
	}
	return h;
    }

    private Node balance(Node h) {

	if (isRed(h.right))
	    h = rotateLeft(h);
	if (isRed(h.right) && !isRed(h.left))
	    h = rotateLeft(h);
	if (isRed(h.left) && isRed(h.left.left))
	    h = rotateRight(h);
	if (isRed(h.left) && isRed(h.right))
	    flipColors(h);

	h.N = size(h.left) + size(h.right) + 1;

	return h;

    }

    private Node deleteMin(Node h) {
	if (h.left == null) {
	    return null;
	}
	if (!isRed(h.left) && !isRed(h.left.left)) {

	    h = moveRedLeft(h);
	}

	h.left = deleteMin(h.left);

	return balance(h);
    }

    private boolean isEmpty() {

	return root.N == 0;
    }

    public void deleteMin() {

	if (!isRed(root.left) && !isRed(root.right)) {
	    root.color = RED;
	}

	root = deleteMin(root);
	if (!isEmpty()) {
	    root.color = BLACK;
	}
    }

    private Node moveRedRight(Node h) {

	flipColors(h);
	if (!isRed(h.left.left)) {
	    h = rotateRight(h);
	}
	return h;

    }

    private Node deleteMax(Node h) {

	if (isRed(h.left)) {
	    h = rotateRight(h);
	}

	if (h.right == null) {
	    return null;
	}

	if (!isRed(h.right) && !isRed(h.right.left)) {
	    h = moveRedRight(h);
	}
	h.right = deleteMax(h.right);

	return balance(h);
    }

    private Node min(Node x) {

	if (x.left == null) {

	    return x;
	}

	return min(x.left);
    }

    private Value get(Node x, Key key) {

	if (x == null)
	    return null;

	int cmp = key.compareTo(x.key);
	if (cmp < 0) {
	    return get(x.left, key);
	} else if (cmp > 0) {
	    return get(x.right, key);
	} else {
	    return x.val;
	}

    }

    private Node delete(Node h, Key key) {

	if (key.compareTo(h.key) < 0) {

	    if (!isRed(h.left) && !isRed(h.left.left)) {
		h = moveRedLeft(h);
	    }
	    h.left = delete(h.left, key);
	} else {

	    if (isRed(h.left)) {
		h = rotateRight(h);
	    }
	    if (key.compareTo(h.key) == 0 && h.right == null) {
		return null;
	    }
	    if (!isRed(h.right) && !isRed(h.right.left)) {
		h = moveRedRight(h);
	    }
	    if (key.compareTo(h.key) == 0) {

		h.val = get(h.right, min(h.right).key);
		h.key = min(h.right).key;
		h.right = deleteMin(h.right);
	    } else {

		h.right = delete(h.right, key);
	    }
	}
	return balance(h);
    }
}
