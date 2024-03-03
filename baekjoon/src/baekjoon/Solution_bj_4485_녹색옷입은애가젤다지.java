package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_4485_녹색옷입은애가젤다지 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int[][] g = new int[N][N];
			int[][] dist = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					g[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = g[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
			pq.offer(new int[] {0,0,dist[0][0]});
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int i = cur[0];
				int j = cur[1];
				int min = cur[2];
				for(int d=0; d<4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(ni>=0&&ni<N&&nj>=0&&nj<N) {
						if(dist[ni][nj]>min+g[ni][nj]) {
							dist[ni][nj] = min + g[ni][nj];
							pq.offer(new int[] {ni,nj,dist[ni][nj]});
						}
					}
				}
			}
			sb.append("Problem "+tc+": "+dist[N-1][N-1]+"\n");
			tc++;
		}
		System.out.println(sb);
		br.close();
	}
}
