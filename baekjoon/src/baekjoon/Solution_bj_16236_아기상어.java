package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16236_아기상어 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static int size = 2;
	static Queue<int[]> eatList = new ArrayDeque<>();
	static int time = 0;
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&arr[ni][nj]<=size) {
					if(arr[ni][nj]<size) {
						eatList.offer(new int[] {ni,nj});
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
		v[i][j] = false;
	}
	static boolean isDone() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(!isDone()) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==9) {
						bfs(0,0);
						if(eatList.isEmpty()) {
							System.out.println(time);
							return;
						} else if(eatList.size()==1) {
							int[] rc = eatList.poll();
							int r = rc[0];
							int c = rc[1];
							arr[i][j] = 0;
							arr[r][c] = 9;
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
