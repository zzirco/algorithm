package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_7562_나이트의이동 {
	static int[] di = {-1,-2,-2,-1,1,2,2,1};
	static int[] dj = {-2,-1,1,2,2,1,-1,-2};
	static int N;
	static int si, sj, ei, ej;
	static int[][] arr;
	static boolean[][] v;
	static int ans;
	static void bfs(int i, int j, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			if(i==ei&&j==ej) {
				ans = cnt;
				return;
			}
			for(int d=0; d<8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,cnt+1});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			ei = Integer.parseInt(st.nextToken());
			ej = Integer.parseInt(st.nextToken());
			bfs(si,sj,0);
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
