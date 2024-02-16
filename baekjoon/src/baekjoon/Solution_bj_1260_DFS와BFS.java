package baekjoon;

import java.io.*;
import java.util.*;
 
public class Solution_bj_1260_DFS와BFS {
	static int N, M, V;
	static int[][] g;
	static boolean[] v;
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print(i+" ");
			for(int j=1; j<=N; j++) {// 0->N
				if(g[i][j]!=0&&!v[j]) {
					v[j]=true;
					q.offer(j);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print(i+" ");
		for(int j=1; j<=N; j++) {// 0->N
			if(g[i][j]!=0&&!v[j]) {
				dfs(j);
			}
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	g = new int[N+1][N+1];
		v = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from][to] = g[to][from] = 1;
		}
    	dfs(V);
    	System.out.println();
    	v = new boolean[N+1];
    	bfs(V);
        br.close();
    }
}
