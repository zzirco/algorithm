package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_11725_트리의부모찾기 {
	static int N;
	static Node[] g;
	static int[] p;
	static boolean[] v;
	static class Node {
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	static void dfs(int i) {
		v[i] = true;
		//System.out.print(i+" ");
		for(Node j=g[i]; j!=null; j=j.link) {// 0->N
			if(!v[j.vertex]) {
				p[j.vertex] = i;
				dfs(j.vertex);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new Node[N+1];
		p = new int[N+1];
		v = new boolean[N+1];
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from] = new Node(to, g[from]);
			g[to] = new Node(from, g[to]);
		}
		dfs(1);
		for(int i=2; i<=N; i++) {
			sb.append(p[i]+"\n");
		}
		System.out.println(sb);
	}
}
