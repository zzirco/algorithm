package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_7569_토마토 {
	static final int[] di = {-1,1,0,0,0,0};
	static final int[] dj = {0,0,-1,1,0,0};
	static final int[] dh = {0,0,0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[N][M][H];
		int[][][] time = new int[N][M][H];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					tomato[i][j][h] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][h]==1) {
						q.offer(new int[] {i,j,h});
					}
					if(tomato[i][j][h]==0) {
						time[i][j][h] = -1;
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i=ij[0];
			int j=ij[1];
			int h=ij[2];
			for(int d=0; d<6; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				int nh=h+dh[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && 0<=nh && nh<H && time[ni][nj][nh]==-1) {
					time[ni][nj][nh] = time[i][j][h] + 1;
					q.offer(new int[]{ni,nj,nh});
				}
			}
		}
		int ans = 0;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(time[i][j][h]==-1) {
						System.out.println(-1);
						return;
					}
					ans = Math.max(ans, time[i][j][h]);
				}
			}
		}
		System.out.println(ans);
	}
}
