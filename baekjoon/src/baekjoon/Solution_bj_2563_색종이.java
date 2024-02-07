package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2563_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		for(int k=0; k<N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					arr[x+i-1][y+j-1] = 1;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				ans+=arr[i][j];
			}
		}
		sb.append(ans+"\n");
		System.out.println(sb);
	}
}
