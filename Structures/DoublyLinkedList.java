package Structures;

import java.io.Serializable;
import java.util.Iterator;
import Nodes.Node;


public class DoublyLinkedList<T> implements Iterable<Node<T>>, Serializable{
	private static final long serialVersionUID = 1L;
	private Node<T> m_cursor;
	private long m_count = 0L;
	private boolean m_finialize;
	
	public Node<T> find(Node<T> item){
		for(Node<T> node: this)
			if(node.equals(item))
				return node;
		
		return null;
	}
	
	public boolean isFinialize() {
		return this.m_finialize;
	}

	public void setFinialize(boolean finialize) {
		this.m_finialize = finialize;
	}

	public DoublyLinkedList<T> add(Node<T> item) {
		if(this.m_count == 0) {
			this.m_cursor = item;
		}
		else {
			this.m_cursor.setNext(item);
			item.setBefore(this.m_cursor);
			this.m_cursor = item;
		}
		m_count++;
		return this;
	}
	
	public boolean delete(Node<T> item){
		for(Node<T> node: this) {
			if(node.equals(item)) {
				if(this.m_finialize)
					try {
						Node<T> before = (Node<T>) node.before();
						Node<T> next = (Node<T>) node.next();
						before.setNext(next);
						next.setBefore(before);
						node.setBefore(null);
						node.setNext(null);
						if(m_finialize)
							finalize();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				this.m_count--;
				return true;
			}
		}
		return false;
	}
	
	public long getCount() {
		return this.m_count;
	}
	
	@Override
	public Iterator<Node<T>> iterator() {
		return new Iterator<Node<T>>() {
			
			public boolean hasNext() {
				return m_cursor == null ? false : m_cursor.hasNext();				
			}
			
			public Node<T> next() {
				Node<T> tmp = m_cursor;
				m_cursor = (Node<T>) m_cursor.next();
				return tmp;				
			}
			
			public void remove() {
				throw new UnsupportedOperationException("method not supported");
			}
		};
	}

}
