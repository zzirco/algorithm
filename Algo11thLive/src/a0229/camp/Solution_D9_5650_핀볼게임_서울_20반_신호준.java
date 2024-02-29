package a0229.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_5650_핀볼게임_서울_20반_신호준 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N;
	static int[][] map;
	static int ans;
	static void solution(int i, int j, int d) {
		int cnt = 0;
		int starti = i;
		int startj = j;
		while(true) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if((ni==starti&&nj==startj)||map[ni][nj]==-1) {
				ans = Math.max(ans, cnt);
				break;
			}
			if(map[ni][nj]==1) {
				if(d==0) {
					d = 1;
					continue;
				} else if(d==1) {
					d = 3;
					i = ni;
					j = nj + 1;
					continue;
				} else if(d==2) {
					d = 0;
					i = ni - 1;
					j = nj;
					continue;
				} else {
					d = 2;
					continue;
				}
			} else if(map[ni][nj]==2) {
				if(d==0) {
					d = 3;
					i = ni;
					j = nj + 1;
					continue;
				} else if(d==1) {
					d = 0;
					continue;
				} else if(d==2) {
					d = 3;
					i = ni + 1;
					j = nj;
					continue;
				} else {
					d = 2;
					continue;
				}
			} else if(map[ni][nj]==3) {
				if(d==0) {
					d = 2;
					i = ni;
					j = nj - 1;
					continue;
				} else if(d==1) {
					d = 0;
					continue;
				} else if(d==2) {
					d = 3;
					continue;
				} else {
					d = 1;
					i = ni + 1;
					j = nj;
					continue;
				}
			} else if(map[ni][nj]==4) {
				if(d==0) {
					d = 1;
					continue;
				} else if(d==1) {
					d = 2;
					i = ni;
					j = nj - 1;
					continue;
				} else if(d==2) {
					d = 3;
					continue;
				} else {
					d = 0;
					i = ni - 1;
					j = nj;
					continue;
				}
			} else if(map[ni][nj]==5) {
				if(d==0) {
					d = 1;
					continue;
				} else if(d==1) {
					d = 0;
					continue;
				} else if(d==2) {
					d = 3;
					continue;
				} else {
					d = 2;
					continue;
				}
			} else if(map[ni][nj]==6) {
				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int d=0; d<4; d++) {
						solution(i,j,d);
					}
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
