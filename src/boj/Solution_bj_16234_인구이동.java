package boj;

import java.io.*;
import java.util.*;

public class Solution_bj_16234_인구이동 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] v;
	static Queue<int[]> q;
	static Queue<int[]> q2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(true) {
			boolean b = false;
			v = new boolean[N][N];
			//매일매일 전체 배열에 대해 인구이동 조사
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j]) {
						q = new ArrayDeque<>();
						q2 = new ArrayDeque<>();
						v[i][j] = true;
						q.offer(new int[] {i,j});
						q2.offer(new int[] {i,j});
						int sum = arr[i][j];
						//연합 구하기
						while(!q.isEmpty()) {
							int[] ij = q.poll();
							int I = ij[0];
							int J = ij[1];
							for(int d=0; d<4; d++) {
								int ni = I + di[d];
								int nj = J + dj[d];
								if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]) {
									int abs = Math.abs(arr[I][J]-arr[ni][nj]);
									if(abs>=L&&abs<=R) {
										v[ni][nj] = true;
										q.offer(new int[] {ni,nj});
										q2.offer(new int[] {ni,nj});
										sum += arr[ni][nj];
									}
								}
							}
						}
						//연합 인구 이동
						if(q2.size()>1) {
							int avg = sum/q2.size();
							while(!q2.isEmpty()) {
								int[] ij = q2.poll();
								int I = ij[0];
								int J = ij[1];
								arr[I][J] = avg;
							}
							b = true;
						}
					}
				}
			}
			//인구이동이 없으면 종료
			if(!b) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
}
