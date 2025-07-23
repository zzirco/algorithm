package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

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
				if(ni>=0&&ni<102&&nj>=0&&nj<102&&!v[ni][nj]) {
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
		a = new int[102][102];
		v = new boolean[102][102];
		ans = 0;
		for(int k=0; k<N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					a[100-x-i][y+j] = 1;
				}
			}
		}
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(a[i][j]==0&!v[i][j])
					bfs(i,j);
			}
		}
		System.out.println(ans);
		br.close();
	}
}
