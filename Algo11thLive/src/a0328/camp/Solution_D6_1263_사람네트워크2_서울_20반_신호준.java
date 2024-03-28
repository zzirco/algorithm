package a0328.camp;

import java.io.*;
import java.util.*;

public class Solution_D6_1263_사람네트워크2_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] g = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					g[i][j] = Integer.parseInt(st.nextToken())==1?1:Integer.MAX_VALUE/2;
				}
			}
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					sum += g[i][j];
				}
				min = Math.min(min, sum);
			}
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
