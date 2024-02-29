package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1600_말이되고픈원숭이 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static final int[] hdi = {-1,-2,-2,-1,1,2,2,1};
	static final int[] hdj = {-2,-1,1,2,2,1,-1,-2};
	static int K, N, M;
	static int[][] arr;
	static boolean[][][] v;
	static int ans;
	static int bfs(int i, int j, int cnt, int hCnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt,hCnt});
		v[i][j][hCnt] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			hCnt = ij[3];
			if(i==N-1&&j==M-1) {
				ans = cnt;
				return ans;
			}
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&arr[ni][nj]==0) {
					if(!v[ni][nj][hCnt]) {
						v[ni][nj][hCnt] = true;
						q.offer(new int[] {ni,nj,cnt+1,hCnt});
					}
				}
			}
			for(int d=0; d<8; d++) {
				int ni = i + hdi[d];
				int nj = j + hdj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&arr[ni][nj]==0) {
					if(!v[ni][nj][hCnt]&&hCnt<K) {
						v[ni][nj][hCnt+1] = true;
						q.offer(new int[] {ni,nj,cnt+1,hCnt+1});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(0,0,0,0));
	}
}
