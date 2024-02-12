package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_17144_미세먼지안녕 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int[] di2 = {1,0,-1,0};
	static int[] dj2 = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		Queue<int[]> filter = new ArrayDeque<>();
		Queue<int[]> dust = new ArrayDeque<>();
		//초기화
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) filter.offer(new int[] {i,j});
			}
		}
		//T초 동안 반복
		for(int t=0; t<T; t++) {
			//미세먼지 확산
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j]>0) dust.offer(new int[] {i,j,arr[i][j]});
				}
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					int cnt = 0;
					int size = dust.size();
					while(cnt<size) {
						int[] ij = dust.poll();
						int I = ij[0];
						int J = ij[1];
						int K = ij[2];
						if(K>=5) {
							int x = K/5;
							for(int d=0; d<4; d++) {
								int ni = I + di[d];
								int nj = J + dj[d];
								if(ni>=0&&ni<R&&nj>=0&&nj<C&&arr[ni][nj]!=-1) {
									arr[ni][nj] += x;
									arr[I][J] -= x;
								}
							}
						}
						cnt++;
					}
				}
			}
			//공기청정기
			int cnt = 0;
			while(cnt<2) {
				filter.offer(filter.peek());
				int[] ij = filter.poll();
				int i = ij[0];
				int j = ij[1];
				int d = 0;
				if(cnt==0) {
					while(d<4) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(ni>=0&&ni<=ij[0]&&nj>=0&&nj<C) {
							if(arr[i][j]==-1) ;
							else if(arr[ni][nj]==-1) arr[i][j] = 0;
							else arr[i][j] = arr[ni][nj];
							i = ni; j = nj;
						} else {
							d++;
						}
					}
				} else {
					while(d<4) {
						int ni = i + di2[d];
						int nj = j + dj2[d];
						if(ni>=ij[0]&&ni<R&&nj>=0&&nj<C) {
							if(arr[i][j]==-1) ;
							else if(arr[ni][nj]==-1) arr[i][j] = 0;
							else arr[i][j] = arr[ni][nj];
							i = ni; j = nj;
						} else {
							d++;
						}
					}
				}
				cnt++;
			}
		}
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]>0) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
