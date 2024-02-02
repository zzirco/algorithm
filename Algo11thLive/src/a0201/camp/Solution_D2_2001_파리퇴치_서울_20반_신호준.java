package a0201.camp;

import java.io.*;
import java.util.*;

public class Solution_D2_2001_파리퇴치_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int sum = 0;
					if(i+M-1<N && j+M-1<N) {
						for(int p=0; p<M; p++) {
							for(int q=0; q<M; q++)
							{
								sum += arr[i+p][j+q];
							}
						}
					}
					if(sum>ans) {
						ans = sum;
					}
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
