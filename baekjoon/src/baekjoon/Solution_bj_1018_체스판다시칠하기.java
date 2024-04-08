package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		char[][] chess = new char[8][8];
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<N-8; i++) {
			for(int j=0; j<M-8; j++) {
				for(int r=0; r<8; r++) {
					for(int c=0; c<8; c++) {
						chess[r][c] = map[i+r][j+c];
					}
				}
				int cnt1=0, cnt2=0;
				for(int r=0; r<N; r++) {
					for(int c=0; c<M; c++) {
						if(r%2==0&&c%2==0&&chess[r][c]=='B') cnt1++;
						if(r%2==0&&c%2==1&&chess[r][c]=='W') cnt1++;
						if(r%2==1&&c%2==0&&chess[r][c]=='W') cnt1++;
						if(r%2==1&&c%2==1&&chess[r][c]=='B') cnt1++;
					}
				}
				for(int r=0; r<N; r++) {
					for(int c=0; c<M; c++) {
						if(r%2==0&&c%2==0&&chess[r][c]=='W') cnt2++;
						if(r%2==0&&c%2==1&&chess[r][c]=='B') cnt2++;
						if(r%2==1&&c%2==0&&chess[r][c]=='B') cnt2++;
						if(r%2==1&&c%2==1&&chess[r][c]=='W') cnt2++;
					}
				}
				ans = Math.min(cnt1, cnt2);
			}
		}
		System.out.println(ans);
	}
}
