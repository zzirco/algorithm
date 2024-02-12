package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16926_배열돌리기1 {
	static int[] di = {0,1,0,-1}; //우하좌상
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Math.min(N, M);
		for(int i=0; i<R; i++) {
			for(int j=0; j<min/2; j++) {
				int I = j;
				int J = j;
				int tmp = arr[I][J];
				int d = 0;
				while(d<4) {
					int ni = I + di[d];
					int nj = J + dj[d];
					if(ni>=j&&ni<N-j&&nj>=j&&nj<M-j) {
						arr[I][J] = arr[ni][nj];
						I = ni; J = nj;
					} else {
						d++;
					}
				}
				arr[j+1][j] = tmp;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
