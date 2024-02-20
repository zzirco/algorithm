import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 */
// 무향 그래프 : 연결리스트 버젼
public class AdjListTest {
	static class Node {
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
		public Node(int to) {
			this.to = to;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node[] adjList = new Node[V]; // 각 정점의 인접리스트의 헤드 저장
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]); // 맨앞으로 삽입 알고리즘
			adjList[to] = new Node(from, adjList[to]);
		}
		//bfs(adjList,0);
		dfs(adjList,new boolean[V],0);
	}
	static void bfs(Node[] adjList, int start) {
		int V = adjList.length;
		
		// 1. 큐와 방문관리 배열 준비
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		// 2. 시작 정점(정점 start) 큐에 넣고 방문체크
		queue.offer(start);
		visited[start] = true;
		
		// 3. 큐로 방문관리
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 4. 탐색해야하는 정점 꺼내기
			// 탐색정점에 관련된 로직 처리
			System.out.println((char)(current+65));
			// 5. 탐색정점의 주변 인접정점들 탐색될수 있도록 처리하기
			for(Node temp=adjList[current]; temp!=null; temp=temp.next) {
				if(!visited[temp.to]) { // 방문여부 체크
					queue.offer(temp.to);
					visited[temp.to] = true;
				}
			}
		}
	}
	static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println((char)(current+65));
		for(Node temp=adjList[current]; temp!=null; temp=temp.next) {
			if(!visited[temp.to]) {
				dfs(adjList, visited, temp.to);
			}
		}
	}
}	
