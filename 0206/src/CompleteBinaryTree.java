
// 완전이진트리 - 배열 구현
// 크기 늘리지 않는 버전

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {
	
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex; // 마지막으로 저장된 노드의 인덱스
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1]; // 0인덱스 사용하지 않음
	}

	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex==SIZE;
	}
	public void add(T e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	// 동일 너비 단위로 처리
	public void bfs3() {
		if(isEmpty()) return;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기(노드 번호인덱스)
		
		int current = 0, size=0, breadth=0;
		while(!queue.isEmpty()) { // 방문할 대상이 있는 동안 반복
			size = queue.size();
			System.out.println("breadth"+breadth+" : "); // 노드 처리
			while(--size>=0) {
				current = queue.poll();
				System.out.println(nodes[current]+"\t");
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			++breadth; // 너비 증가(다음 탐색을 위해)
		}
	}
	// 큐에 탐색할 노드 번호와 너비 함께 넣기
	public void bfs2() {
		if(isEmpty()) return;
				
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1,0});
		
		int[] info;
		while(!queue.isEmpty()) { // 방문할 대상이 있는 동안 반복
			info = queue.poll();
			int current = info[0];
			int breadth = info[1];
			System.out.println(nodes[current]+"("+breadth+")"); // 노드 처리
			if(current*2<=lastIndex) queue.offer(new int[] {current*2,breadth+1});
			if(current*2+1<=lastIndex) queue.offer(new int[] {current*2+1,breadth+1});
		}
	}
	public void bfs() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기(노드 번호인덱스)
		
		while(!queue.isEmpty()) { // 방문할 대상이 있는 동안 반복
			int current = queue.poll();
			System.out.println(nodes[current]); // 노드 처리
			
			// 왼쪽 자식노드
			if(current*2<=lastIndex) queue.offer(current*2);
			// 오른쪽 자식노드
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void dfsByPreorder() {
		if(isEmpty()) return;
		System.out.println("===preorder===");
		dfsByPreorder(1);
		System.out.println();
	}
	private void dfsByPreorder(int current) { // 전위 순회
		System.out.print(nodes[current]+" "); // 노드 처리
		// 왼쪽 자식노드
		if(current*2<=lastIndex) dfsByPreorder(current*2);
		// 오른쪽 자식노드
		if(current*2+1<=lastIndex) dfsByPreorder(current*2+1);
	}
	
	public void dfsByInorder() {
		if(isEmpty()) return;
		System.out.println("===inorder===");
		dfsByInorder(1);
		System.out.println();
	}
	private void dfsByInorder(int current) { // 중위 순회
		// 왼쪽 자식노드
		if(current*2<=lastIndex) dfsByInorder(current*2);
		System.out.print(nodes[current]+" "); // 노드 처리
		// 오른쪽 자식노드
		if(current*2+1<=lastIndex) dfsByInorder(current*2+1);
	}
	
	public void dfsByPostorder() {
		if(isEmpty()) return;
		System.out.println("===postorder===");
		dfsByPostorder(1);
		System.out.println();
	}
	private void dfsByPostorder(int current) { // 중위 순회
		// 왼쪽 자식노드
		if(current*2<=lastIndex) dfsByPostorder(current*2);
		// 오른쪽 자식노드
		if(current*2+1<=lastIndex) dfsByPostorder(current*2+1);
		System.out.print(nodes[current]+" "); // 노드 처리
	}
}
