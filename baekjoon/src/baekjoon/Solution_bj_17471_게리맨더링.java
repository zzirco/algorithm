package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_17471_게리맨더링 {
	static int N, R;
	static Node[] g;
	static boolean[] v;
	static int[] a,b;
	static int[] population;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		population = new int[N+1];
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		g = new Node[N+1];
		v = new boolean[N+1];
		a = new int[N];
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = i;
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int to = Integer.parseInt(st.nextToken());
				g[from] = new Node(to, g[from]);
				g[to] = new Node(from, g[to]);
			}
		}
		for(int i=1; i<N; i++) {
			R = i;
			b = new int[R];
			comb(0,0);
		}
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	static void comb(int cnt, int start) {
		if(cnt==R) {
			int[] c = new int[N-R];
			int idx = 0;
			v = new boolean[N+1];
			A:for(int i=1; i<=N; i++) {
				for(int item:b) {
					if(i==item) continue A;
				}
				c[idx] = i;
				idx++;
			}
			//System.out.println("b : "+Arrays.toString(b));
			//System.out.println("c : "+Arrays.toString(c));
			bfs(b[0],b);
			bfs(c[0],c);
			int bp = 0, cp = 0;
			boolean isOk = true;
			for(int i=1; i<=N; i++) {
				if(!v[i]) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				for(int item:b) bp += population[item];
				for(int item:c) cp += population[item];
				ans = Math.min(ans, Math.abs(bp-cp));
			}
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}
	static void bfs(int i, int[] ia) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		v[i]=true;
		while(!q.isEmpty()) {
			i = q.poll();
			for(Node j=g[i]; j!=null; j=j.link) {
				for(int item:ia) {
					if(j.vertex==item&&!v[j.vertex]) {
						v[j.vertex]=true;
						q.offer(j.vertex);
					}
				}
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
