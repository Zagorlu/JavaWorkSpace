package Structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import Nodes.Node;
import static Util.NodeUtil.*;

public class DoublyLinkedList<T> implements Iterable<T>, Serializable{
	private static final long serialVersionUID = 1L;
	private Node<T> m_cursor, m_head, m_tail;
	private long m_count = 0L;
	private boolean m_finialize;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(Collection<? extends T> c) {
		for(T t: c)
			this.add(t);
	}
	
	public DoublyLinkedList<T> add(T item) {
		nullControll(item);
		
		Node<T> buffer = createNode(item);
		if(this.m_count == 0) {
			this.m_cursor = buffer;
			this.m_head = buffer;
			this.m_tail = buffer;
		}
		else {
			this.m_tail.setNext(buffer);
			buffer.setBefore(this.m_tail);
			this.m_tail = buffer;
		}
		this.m_count++;
		return this;
	}
	
	public DoublyLinkedList<T> appendHead(T item) {
		nullControll(item);
		
		Node<T> buffer = createNode(item);
		buffer.setNext(this.m_head);
		this.m_head.setBefore(buffer);
		this.m_head = buffer;
		setCursorToHead();
		this.m_count++;
		return this;
	}
	
	public DoublyLinkedList<T> appendTail(T item) {
		add(item);
		return this;
	}
	
	protected void callGarbageCollector() {
		try {
			if(isFinialize())
				finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public boolean delete(T item){
		if(this.m_count == 0)
			return false;
		
		nullControll(item);
		Node<T> tmp = findElement(item);
		if(tmp == null)
			return false;
		
		if(tmp.hasNext() && tmp.hasBefore()) {
			Node<T> next = (Node<T>) tmp.next();
			Node<T> before = (Node<T>) tmp.before();
			next.setBefore(before);
			before.setNext(next);
		}
		
		if(tmp.hasNext()) {
			Node<T> next = (Node<T>) tmp.next();
			this.m_head = next;
			next.breakBefore();
			setCursorToHead();
		}
		else {
			Node<T> before = (Node<T>) tmp.before();
			this.m_tail = before;
			before.breakNext();
		}
		
		tmp.breakBefore();
		tmp.breakNext();
		callGarbageCollector();
		
		this.m_count--;
		return true;
	}
	
	public T find(T item){
		nullControll(item);
		for(T node: this)
			if(node.equals(item))
				return node;
		
		return null;
	}
	
	protected Node<T> findElement(T item){
		nullControll(item);
		Node<T> tmp = this.m_head;
		
		do {
			if(tmp.getData().equals(item))
				return tmp;
			
		} while((tmp = (Node<T>) tmp.next()) != null);
		
		return null;
	}
	
	public void freeAllList() {
		Node<T> tmp = this.m_head;
		
		do {
			tmp.breakAll();
		} while((tmp = (Node<T>) tmp.next()) != null);
		this.m_head = this.m_tail = this.m_cursor = null;
		this.m_count = 0L;
		this.m_finialize = false;
	}
	
	public long getCount() {
		return this.m_count;
	}

	public boolean insert(T item, T point) {
		return insert(item, point, false);
	}
	
	public boolean insert(T item, T point, boolean addTailIfNotFound) {
		nullControll(item);
		nullControll(point);
		Node<T> before = findElement(point);
		
		if(addTailIfNotFound && before == null) {
			appendTail(item);
			return true;
		}
		
		if(before == null)
			return false;		
		
		if(!before.hasNext()) {
			appendTail(item);
			return true;
		}
		if(!before.hasBefore()){
			appendHead(item);
			return true;
		}
		
		Node<T> next = (Node<T>) before.next();
		Node<T> buffer = createNode(item);
		buffer.setNext(next);
		buffer.setBefore(before);
		next.setBefore(buffer);
		before.setNext(buffer);
		
		this.m_count++;
		return false;
	}
	
	public boolean isFinialize() {
		return this.m_finialize;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			public boolean hasNext() {
				if(m_cursor == null) {
					setCursorToHead();
					return false;
				}
				return true;
			}
			
			public T next() {
				Node<T> tmp = m_cursor;
				m_cursor = (Node<T>) m_cursor.next();
				return tmp.getData();				
			}
			
			public void remove() {
				throw new UnsupportedOperationException("method not supported");
			}
		};
	}

	public DoublyLinkedList<T> removeHead() {
		Node<T> tmp = (Node<T>) this.m_head;		
		this.m_head = (Node<T>) this.m_head.next();
		this.m_head.breakBefore();
		tmp.breakBefore();
		tmp.breakNext();
		callGarbageCollector();
		setCursorToHead();
		this.m_count--;
		return this;
	}
	
	public DoublyLinkedList<T> removeTail() {
		Node<T> tmp = (Node<T>) this.m_tail;		
		this.m_tail = (Node<T>) this.m_tail.before();
		this.m_tail.breakNext();
		tmp.breakBefore();
		tmp.breakNext();
		callGarbageCollector();
		setCursorToHead();
		this.m_count--;
		return this;
	}

	protected void setCursorToHead() {
		this.m_cursor = this.m_head;
	}
	
	protected void setCursorToTail() {
		this.m_cursor = this.m_tail;
	}
	
	public void setFinialize(boolean finialize) {
		this.m_finialize = finialize;
	}
}
