import java.io.*;
import java.util.*;

public class asdf {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int max;
	static void bfs(int i, int j) {
		int cnt = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		cnt++;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<n&&nj>=0&&nj<m&&!v[ni][nj]&&map[ni][nj]==1) {
					q.offer(new int[] {ni,nj});
					cnt++;
					v[ni][nj] = true;
				}
			}
		}
		max = Math.max(max, cnt);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		max = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1&&!v[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
}
