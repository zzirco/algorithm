package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_bj_2583_영역구하기 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M, K;
	static int[][] arr;
	static boolean[][] v;
	static int ans;
	static ArrayList<Integer> list = new ArrayList<>();
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&arr[ni][nj]==0) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
					cnt++;
				}
			}
		}
		list.add(cnt);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			for(int i=x1; i<=x2; i++) {
				for(int j=y1; j<=y2; j++) {
					arr[j][i] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j]&&arr[i][j]==0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int num:list) System.out.print(num+" ");
	}
}
