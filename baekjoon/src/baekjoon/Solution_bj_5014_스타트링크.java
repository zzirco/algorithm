package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_5014_스타트링크 {
	static int[] di;
	static int F,S,G,U,D;
	static int[] arr;
	static boolean[] v;
	static int ans = Integer.MAX_VALUE;
	static void bfs(int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {S-1,cnt});
		v[S-1] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0];
			cnt = ij[1];
			if(i==G-1) {
				ans = cnt;
				return;
			}
			for(int d=0; d<2; d++) {
				int ni = i + di[d];
				if(ni>=0&&ni<F&&!v[ni]) {
					q.offer(new int[] {ni,cnt+1});
					v[ni] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		di = new int[2];
		di[0] = U;
		di[1] = -D;
		arr = new int[F];
		v = new boolean[F];
		bfs(0);
		if(ans==Integer.MAX_VALUE) System.out.println("use the stairs");
		else System.out.println(ans);
	}
}
