import java.util.Iterator;

/*
 *  created by zzy ,at 3:22:56 PM,May 31, 2017
*/
public class Bag<Item> implements Iterable<Item> {

	
	
	private Node first;
	
	private class Node{
		
		Item item;
		Node next;
		
	}
	
	public  void add(Item item){
		
		
		Node oldfirst=first;
		
		first=new Node();
		
		first.item=item;
		first.next=oldfirst;
		
	}
	
	public Iterator<Item> iterator(){
		
		return null;
	}
	
	private class ListIterator implements Iterator<Item>{

		
		private Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
		    Item item =current.item;
		    
		    current=current.next;
		    return item;
		}
		
		
	}
}

