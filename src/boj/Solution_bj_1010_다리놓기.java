package boj;

import java.util.Scanner;

public class Solution_bj_1010_다리놓기 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			int[][] B = new int[N+1][M+1];
			
			for(int i=0; i<=N; i++) {
				for(int j=0, end=Math.min(i, M); j<=end; ++j) {
					if(j==0||j==i) B[i][j] = 1;
					else B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
			sb.append(B[N][M]+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
