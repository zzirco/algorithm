package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_16933 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M, K;
	static int[][] map;
	static boolean[][][] v;
	static int ans = -1;
	
	static void bfs(int i, int j, int cnt, int wallCnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt,wallCnt});
		v[i][j][wallCnt] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			cnt = cur[2];
			wallCnt = cur[3];
			if(i==N-1&&j==M-1) {
				ans = cnt;
				return;
			}
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni<0||ni>=N||nj<0||nj>=M||v[ni][nj][wallCnt]) continue;
				else {
					if(wallCnt<K) {
						if(map[ni][nj]==1) {
							if(cnt%2==1) {
								q.offer(new int[] {ni,nj,cnt+1,wallCnt+1});
								v[ni][nj][wallCnt+1] = true;
								v[ni][nj][wallCnt] = true;
							} else {
								q.offer(new int[] {i,j,cnt+1,wallCnt});
							}
						} else {
							q.offer(new int[] {ni,nj,cnt+1,wallCnt});
							v[ni][nj][wallCnt] = true;
						}
						
					} else {
						if(map[ni][nj]==1) continue;
						q.offer(new int[] {ni,nj,cnt+1,wallCnt});
						v[ni][nj][wallCnt] = true;
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
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M][K+1];
		for(int i=0; i<N; i++) {
			String[] sarr = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);
			}
		}
		bfs(0,0,1,0);
		System.out.println(ans);
	}
}
