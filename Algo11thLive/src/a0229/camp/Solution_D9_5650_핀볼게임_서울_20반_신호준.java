package a0229.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_5650_핀볼게임_서울_20반_신호준 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N;
	static int[][] map;
	static ArrayList<int[]> startlist = new ArrayList<>();
	static ArrayList<int[]> wormhole = new ArrayList<>();
	static int ans;
	static void solution(int i, int j, int d) {
		int cnt = 0;
		int starti = i;
		int startj = j;
		while(true) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0||ni>=N||nj<0||nj>=N) {
				if(d==0) d = 1;
				else if(d==1) d = 0;
				else if(d==2) d = 3;
				else d = 2;
				ni = i;
				nj = j;
				cnt++;
			}
			if((ni==starti&&nj==startj)||map[ni][nj]==-1) {
				ans = Math.max(ans, cnt);
				break;
			}
			if(map[ni][nj]>=1&&map[ni][nj]<=5) {
				cnt++;
				i = ni;
				j = nj;
				if(map[ni][nj]==1) {
					if(d==0) d = 1;
					else if(d==1) d = 3;
					else if(d==2) d = 0;
					else d = 2;
				} else if(map[ni][nj]==2) {
					if(d==0) d = 3;
					else if(d==1) d = 0;
					else if(d==2) d = 1;
					else d = 2;
				} else if(map[ni][nj]==3) {
					if(d==0) d = 2;
					else if(d==1) d = 0;
					else if(d==2) d = 3;
					else d = 1;
				} else if(map[ni][nj]==4) {
					if(d==0) d = 1;
					else if(d==1) d = 2;
					else if(d==2) d = 3;
					else d = 0;
				} else if(map[ni][nj]==5) {
					if(d==0) d = 1;
					else if(d==1) d = 0;
					else if(d==2) d = 3;
					else d = 2;
				}
			} else if(map[ni][nj]>=6&&map[ni][nj]<=10) {
				for(int[] list:wormhole) {
					if(list[2]==map[ni][nj]&&(list[0]!=ni||list[1]!=nj)) {
						i = list[0];
						j = list[1];
						continue;
					}
				}
			} else {
				i = ni;
				j = nj;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			ans = 0;
			startlist = new ArrayList<>();
			wormhole = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==0) {
						startlist.add(new int[] {i,j});
					}
					if(map[i][j]>=6&&map[i][j]<=10) {
						wormhole.add(new int[] {i,j,map[i][j]});
					}
				}
			}
			for(int[] list:startlist) {
				for(int d=0; d<4; d++) {
					solution(list[0],list[1],d);
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
