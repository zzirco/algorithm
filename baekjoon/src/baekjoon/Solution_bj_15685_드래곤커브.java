package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15685_드래곤커브 {
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static int[][] map = new int[101][101];
	static boolean[][] v = new boolean[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
			int ny = y + dy[d];
			int nx = x + dx[d];
			map[ny][nx] = 1;
			for(int j=0; j<g; j++) {
			}
			
		}
		
	}

}
