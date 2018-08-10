package Nodes;

import java.io.Serializable;

public class Node<T> extends NodeTemplate<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T m_data;
	
	public Node(T data) {
		m_data = data;
	}

	@Override
	public boolean hasData() {
		return this.m_data != null;
	}

	@Override
	public String toString() {
		return this.m_data.toString();
	}
	
	public String toString(String format) {
		return String.format(format, this.m_data.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return this.m_data.equals((T)obj);
	}

	@Override
	public void setData(T data) {
		this.m_data = data;
	}

	@Override
	public T getData() {
		return this.m_data;
	}

	@Override
	public void breakNext() {
		this.m_next = null;
	}

	@Override
	public void breakBefore() {
		this.m_before = null;
	}

	@Override
	public void breakAll() {
		this.breakNext();
		this.breakBefore();
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
