package a0206.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_1868_파핑파핑지뢰찾기_서울_20반_신호준 {
	static final int[] di= {-1,-1,-1,0,1,1,1,0}; //좌상부터 시계방향
	static final int[] dj= {-1,0,1,1,1,0,-1,-1};
	static int N;
	static char[][] map;
	static int[][] mineCnt;
	static boolean[][] v;
	
	static void countMine() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int d=0; d<8; d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && map[ni][nj]=='*') {
						cnt++;
					}
				}
				mineCnt[i][j] = cnt;
			}
		}
	}
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			for(int d=0; d<8; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && map[ni][nj]=='.') {
					v[ni][nj]=true;
					if(mineCnt[ni][nj]==0) {
						q.offer(new int[]{ni,nj});
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			v = new boolean[N][N];
			map = new char[N][N];
			mineCnt = new int[N][N];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			countMine();
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mineCnt[i][j]==0&&v[i][j]==false&&map[i][j]!='*') {
						bfs(i,j);
						cnt++;
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mineCnt[i][j]!=0&&map[i][j]!='*'&&v[i][j]==false) {
						cnt++;
					}
				}
			}
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
