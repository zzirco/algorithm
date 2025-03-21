package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2644_촌수계산 {
	static int N;
	static int[][] g;
	static boolean[] v;
	public static int bfs(int start, int end, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start,cnt});
		v[start] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			start = cur[0];
			cnt = cur[1];
			if(start==end) return cnt;
			for(int i=1; i<=N; i++) {
				if(!v[i]&&g[start][i]!=0) {
					q.offer(new int[] {i, cnt+1});
					v[i] = true;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		g = new int[N+1][N+1];
		v = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from][to] = g[to][from] = 1;
		}
		System.out.println(bfs(start, end, 0));
	}
}
