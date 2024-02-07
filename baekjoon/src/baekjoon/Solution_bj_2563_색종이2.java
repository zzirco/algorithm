package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2563_색종이2 {
	static final int[] di= {-1,-1,-1,0,1,1,1,0}; 
	static final int[] dj= {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[100][100];
		for(int k=0; k<N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					a[x+i-1][y+j-1] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<100; i++) {
			A:for(int j=0; j<100; j++) {
				if(a[i][j]==1) {
					for(int d=0; d<8; d++) {
						int ni=i+di[d];
						int nj=j+dj[d];
						if(0<=ni && ni<100 && 0<=nj && nj<100) {
							if(a[ni][nj]==0) {
								cnt++;
								continue A;
							}
						} else {
							cnt++;
							continue A;
						}
					}
				}
			}
		}
		sb.append(cnt+"\n");
		System.out.println(sb);
	}
}
