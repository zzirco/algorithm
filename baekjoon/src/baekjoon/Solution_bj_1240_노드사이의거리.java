package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1240_노드사이의거리 {
	static int N, M;
	static int[][] g;
	static boolean[] v;
	static int bfs(int from, int to, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {from, cnt});
		v[from] = true;
		A:while(!q.isEmpty()) {
			int[] cur = q.poll();
			from = cur[0];
			cnt = cur[1];
			for(int i=0; i<N; i++) {
				if(g[from][i]!=0&&!v[i]) {
					q.offer(new int[] {i, cnt + g[from][i]});
					if(i==to) {
						return cnt + g[from][i];
					}
					v[i] = true;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[N][N];
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			g[from][to] = g[to][from] = weight;
		}
		for(int i=0; i<M; i++) {
			v = new boolean[N];
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int ans = bfs(from, to, 0);
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
