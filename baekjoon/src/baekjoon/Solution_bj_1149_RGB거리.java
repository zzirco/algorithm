package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(sb);
	}
}
