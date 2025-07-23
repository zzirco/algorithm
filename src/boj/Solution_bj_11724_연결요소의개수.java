package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_11724_연결요소의개수 {
	static int N, M;
	static int[][] g;
	static boolean[] v;
	public static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			for(int j=0; j<N; j++) {
				if(j==i) continue;
				if(g[i][j]!=0&&!v[j]) {
					q.offer(j);
					v[j] = true;
				}
				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[N][N];
		v = new boolean[N];
		int cnt = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			g[from][to] = g[to][from] = 1;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
