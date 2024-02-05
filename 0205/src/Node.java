
public class Node<T> {
	public T data;
	public Node<T> link;
	public Node(T data) {
		super();
		this.data = data;
	}
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}
