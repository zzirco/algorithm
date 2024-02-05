package a0205.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_7733_치즈도둑_서울_20반_신호준 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int ans;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer ST = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(ST.nextToken());
				}
			}
			
			ans = 0;
			
			for(int day=0; day<=100; day++) {
				visited = new boolean[N][N];
				int cnt = 0;
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][j]==day) {
							arr[i][j] = 0;
						}
					}
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][j]!=0 && visited[i][j]==false) {
							bfs(i, j);
							cnt++;
						}
					}
				}
				
				if(cnt>ans) {
					ans = cnt;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int X = p.x + dx[i];
				int Y = p.y + dy[i];
				
				if(X>=0 && X<arr.length && Y>=0 && Y<arr.length && arr[X][Y]!=0 && visited[X][Y]==false) {
					visited[X][Y] = true;
					q.offer(new Point(X, Y));
				}
			}
		}
	}
}


