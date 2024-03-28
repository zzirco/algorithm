package a0328.camp;

import java.io.*;
import java.util.*;

public class Solution_D5_7793_오나의여신님_서울_20반_신호준 {
	static int si, sj, ei, ej;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static char[][] map;
	static boolean[][] v;
	public static void bfs(int i, int j, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			v = new boolean[N][M];
			for(int i=0; i<N; i++) {
				map[i] =  st.nextToken().toCharArray();
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='S') {
						si = i;
						sj = j;
					} else if(map[i][j]=='D') {
						ei = i;
						ej = j;
					}
				}
			}
			bfs(si,sj,0);
			sb.append("#"+tc+" "+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
