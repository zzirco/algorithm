package a0229.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_2117_홈방범서비스_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int K = 2*N-1;
			int operCost = K * K + (K - 1) * (K - 1);
			int revenue = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int p=0; p<N; p++) {
						for(int q=0; q<N; q++) {
							int mandist = Math.abs(arr[i][j]);
						}
					}
				}
			}
			sb.append(Arrays.deepToString(arr)+"\n");
		}
		System.out.println(sb);
	}
}
