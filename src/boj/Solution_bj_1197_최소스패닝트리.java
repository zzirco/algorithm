package boj;

import java.util.Scanner;

public class Solution_bj_1197_최소스패닝트리 {
	static class Node {
		int vertex;
		int weight;
		Node link;
		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		Node[] g = new Node[N];
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N];
		
		for(int i=0; i<N; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<E; i++) {
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int weight = sc.nextInt();
			g[from] = new Node(to,weight,g[from]);
			g[to] = new Node(from,weight,g[to]);
		}
		int result = 0, cnt = 0;
		minEdge[0] = 0;
		
		for(int i=0; i<N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!v[j]&&min>minEdge[j]) {
					minVertex = j;
					min = minEdge[j];
				}
			}
			v[minVertex] = true;
			result += min;
			if(cnt++==N-1) break;
			for(Node j=g[minVertex]; j!=null; j=j.link) {
				if(!v[j.vertex]&&minEdge[j.vertex]>j.weight) {
					minEdge[j.vertex] = j.weight;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
