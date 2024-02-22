package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15683_감시 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static void up(int i, int j, int[][]arr) {
		int ni = i + di[0];
		int nj = j + dj[0];
		if(ni>=0&&ni<N&&nj>=0&&nj<M) {
			arr[ni][nj] = -1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(ans);
	}
}
