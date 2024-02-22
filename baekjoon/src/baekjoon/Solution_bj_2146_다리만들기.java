package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2146_다리만들기 {
	static int N;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] v;
	static int ans = Integer.MAX_VALUE;
	static void bfs(int i, int j, int islandNum) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		arr[i][j] = islandNum;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]&&arr[ni][nj]==1) {
					v[ni][nj] = true;
					arr[ni][nj] = islandNum;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	static void bfs2(int i, int j, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt});
		v[i][j] = true;
		int islandNum = arr[i][j];
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]&&arr[ni][nj]!=islandNum) {
					if(arr[ni][nj]!=0) {
						ans = Math.min(ans, cnt+1);
						continue;
					}
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
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 구분 작업
		int islandNum = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1&&!v[i][j]) {
					bfs(i,j,islandNum);
					islandNum++;
				}
			}
		}
		// 다리 건설
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]!=0) {
					v = new boolean[N][N];
					bfs2(i,j,0);
				}
			}
		}
		System.out.println(ans-1);
	}
}
