package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2252_줄세우기 {
	static int V, E;
	static Node[] adjList;
	static int[] indegree;
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
			return " [to=" + to + ", next=" + next + "]";
		}
	}
	static void bfs(Node[] adjList) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V+1];
		for(int i=1; i<=V; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			for(Node temp=adjList[current]; temp!=null; temp=temp.next) {
				if(!visited[temp.to]) {
					if(indegree[temp.to]!=0) {
						if(--indegree[temp.to]!=0) {
							continue;
						}
					}
					visited[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new Node[V+1];
		indegree = new int[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			indegree[to]++;
		}
		bfs(adjList);
	}
}
