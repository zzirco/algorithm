package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_10711_모래성 {
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	static int N, M;
	static int[][] map;
	static int ans;
	static ArrayDeque<int[]> q;
	static void bfs() {
		while(!q.isEmpty()) {
			ans++;
			int qSize = q.size();
			for(int k=0; k<qSize; k++) {
				int[] cur = q.poll();
				int i = cur[0];
				int j = cur[1];
				for(int d=0; d<8; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]>=1&&map[ni][nj]<=8) {
						map[ni][nj]--;
						if(map[ni][nj]==0) {
							q.offer(new int[] {ni,nj});
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			String[] sa = br.readLine().split("");
			for(int j=0; j<M; j++) {
				if(sa[j].equals(".")) {
					map[i][j] = 0;
					q.offer(new int[] {i,j});
				} else {
					map[i][j] = Integer.parseInt(sa[j]);
				}
			}
		}
		bfs();
		System.out.println(ans-1);
	}
}
