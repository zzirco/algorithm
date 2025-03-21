package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1697_숨바꼭질 {
	static int N, K;
	static int[] dx = {-1,1};
	static int[] dx2 = {2};
	static int[] g = new int[100001];
	static boolean[] v = new boolean[100001];
	public static int bfs(int x, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,cnt});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			cnt = cur[1];
			if(x==K) {
				return cnt;
			}
			for(int d=0; d<2; d++) {
				int nx = x + dx[d];
				if(nx>=0&&nx<=100000&&!v[nx]) {
					q.offer(new int[] {nx,cnt+1});
					v[nx] = true;
				}
			}
			int nx2 = x * dx2[0];
			if(nx2>=0&&nx2<=100000&&!v[nx2]) {
				q.offer(new int[] {nx2,cnt+1});
				v[nx2] = true;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int ans = bfs(N,0);
		System.out.println(ans);
	}
}
