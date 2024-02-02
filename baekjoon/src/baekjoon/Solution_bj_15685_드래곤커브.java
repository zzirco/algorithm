package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15685_드래곤커브 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			for(int j=0; j<g; j++) {
				arr[y][x] = true;
			}
			
		}
		
		System.out.println(Arrays.deepToString(arr));
	}

}
