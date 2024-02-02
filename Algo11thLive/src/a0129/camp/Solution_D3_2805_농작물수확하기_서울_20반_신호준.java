package a0129.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_2805_농작물수확하기_서울_20반_신호준 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				String[] sa = s.split("");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(sa[j]);
				}
			}
			
			int ans = 0;
			int cnt = N/2;
			int tmp = 0;
			for(int i=0; i<=N/2; i++) {
				for(int j=0; j<N; j++) {
					if(tmp==cnt) {
						for(int k=cnt; k<N-cnt; k++) {
							ans += arr[i][k];
						}
						cnt--;
						tmp = 0;
						break;
					}
					tmp++;
				}
			}
			cnt = 1;
			tmp = 0;
			for(int i=N/2+1; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(tmp==cnt) {
						for(int k=cnt; k<N-cnt; k++) {
							ans += arr[i][k];
						}
						cnt++;
						tmp = 0;
						break;
					}
					tmp++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
