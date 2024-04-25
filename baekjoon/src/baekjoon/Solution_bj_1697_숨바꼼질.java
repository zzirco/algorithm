package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1697_숨바꼼질 {
	static int[] di;
	static int S,D;
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
			if(i==D-1) {
				ans = cnt;
				return;
			}
			for(int d=0; d<2; d++) {
				int ni = i + di[d];
				if(ni>=0&&ni<D&&!v[ni]) {
					q.offer(new int[] {ni,cnt+1});
					v[ni] = true;
				}
			}
			int ni = i * di[2];
			if(ni>=0&&ni<D&&!v[ni]) {
				q.offer(new int[] {ni,cnt+1});
				v[ni] = true;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		di = new int[3];
		di[0] = -1;
		di[1] = 1;
		di[2] = 2;
		arr = new int[D];
		v = new boolean[D];
		bfs(0);
		System.out.println(ans);
	}
}
