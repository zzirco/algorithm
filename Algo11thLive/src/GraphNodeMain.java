import java.io.*;
import java.util.*;

public class GraphNodeMain {
	static int N;
	static Node[] g;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/graph_input2.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new Node[N];
		v = new boolean[N];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from] = new Node(to, g[from]);
			g[to] = new Node(from, g[to]);
		}
		for(Node a:g) System.out.println(a); System.out.println();
		//for(int i=0; i<N; i++) System.out.println((char)(i+'A')+""+i+": "+g[i]); System.out.println();
		//bfs(0);
		dfs(0);
		sc.close();
	}
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
			for(Node j=g[i]; j!=null; j=j.link) {// 0->N
				if(!v[j.vertex]) {
					v[j.vertex]=true;
					q.offer(j.vertex);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		for(Node j=g[i]; j!=null; j=j.link) {// 0->N
			if(!v[j.vertex]) {
				dfs(j.vertex);
			}
		}
	}
	static class Node {
		int vertex;
		Node link;
		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			//return vertex+"->"+link;
			return (char)(vertex+'A')+""+vertex+"->"+link;
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