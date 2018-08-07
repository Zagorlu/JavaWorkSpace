package Nodes;

import java.io.Serializable;

public abstract class NodeTemplate<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private NodeTemplate<T> m_next, m_before;
	
	public NodeTemplate(){}
		
	public NodeTemplate(NodeTemplate<T> before, NodeTemplate<T> next) {
		this.m_next 	 = next;
		this.m_before = before;
	}

	public void setNext(NodeTemplate<T> node) { this.m_next = node; }
	public void setBefore(NodeTemplate<T> node) { this.m_before = node; }
	
	public NodeTemplate<T> next() {
		return this.m_next;
	}
	
	public NodeTemplate<T> before() {
		return this.m_before;
	}
	
	public boolean hasNext() {
		return this.m_next != null;
	}
	
	public boolean hasBefore() {
		return this.m_before != null;
	}

	public abstract boolean hasData();
	public abstract String toString();
	public abstract boolean equals(Object obj);
	public abstract void setData(T t);
	public abstract T getData(T t);
}
