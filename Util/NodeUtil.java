package Util;

import Nodes.Node;

public final class NodeUtil {
	private NodeUtil() {}
	
	public static <T> Node<T> createNode(T item){
		return new Node<T>(item);
	}
	
	public static <T> void nullControll(T item, String msg) {
		if(item == null)
			throw new NullPointerException(msg);
	}
	
	public static <T> void nullControll(T item) {
		nullControll(item,"");
	}
	
	public static <T> void nodeInsert(T item, Node<T> before, Node<T> next) {
		nullControll(item, "Value can not be null...");
		if(before == null || next == null)
			return;
		
		Node<T> buffer = (Node<T>) createNode(item);
		buffer.setNext(next);
		buffer.setBefore(before);
		next.setBefore(buffer);
		before.setNext(buffer);
	}
}
