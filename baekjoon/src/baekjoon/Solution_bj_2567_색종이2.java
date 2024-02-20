package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2567_색종이2 {
	static final int[] di= {-1,1,0,0}; 
	static final int[] dj= {0,0,-1,1};
	static int[][] a;
	static boolean[][] v;
	static int ans;
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<100&&nj>=0&&nj<100&&!v[ni][nj]) {
					if(a[ni][nj]==1) {
						ans++;
						continue;
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[100][100];
		v = new boolean[100][100];
		ans = 0;
		for(int k=0; k<N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					a[99-x-i][y+j-1] = 1;
				}
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(a[i][j]==0&!v[i][j])
					bfs(i,j);
			}
		}
		System.out.println(ans);
		br.close();
	}
}
