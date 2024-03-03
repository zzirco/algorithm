import java.io.*;
import java.util.*;

public class GraphNodeMain2 {
	static int N;
	static Node[] g;
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
	public static void main(String[] arsg) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new Node[N];
		v = new boolean[N];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from] = new Node(to, g[to]);
			g[to] = new Node(from, g[from]);
		}
		bfs(0);
		v = new boolean[N];
		System.out.println();
		dfs(0);
	}
	private static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		v[i] = true;
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
			for(Node j=g[i]; j!=null; j=j.link) {
				if(!v[j.vertex]) {
					v[j.vertex] = true;
					q.offer(j.vertex);
				}
			}
		}
	}
	private static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		for(Node j=g[i]; j!=null; j=j.link) {
			if(!v[j.vertex]) {
				v[j.vertex] = true;
				dfs(j.vertex);
			}
		}
	}
}
/*
....A0
.../.\
..B1.C2
./.\./
D3..E4
..\.|
...F5-G6

7
8
0 1
0 2    
1 3
1 4
2 4
3 5
4 5
5 6

=dfs=========
A B D F E C G : 0->N
A C E F G D B : N->0
=bfs=========
A B C D E F G : 0->N
A C B E D F G : N->0
*/