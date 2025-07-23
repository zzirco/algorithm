package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_10026_적록색약 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static char[][] arr;
	static boolean[][] v;
	static int ans;
	static void bfs(int i, int j, char color) {
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
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]&&arr[ni][nj]==color) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		v = new boolean[N][N];
		char[] color = {'R','G','B'};
		char[] color2 = {'R','B'};
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for(char c:color) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j]&&arr[i][j]==c) {
						bfs(i,j,c);
						cnt++;
					}
				}
			}
		}
		sb.append(cnt+" ");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='G') arr[i][j]='R';
			}
		}
		cnt = 0;
		v = new boolean[N][N];
		for(char c:color2) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j]&&arr[i][j]==c) {
						bfs(i,j,c);
						cnt++;
					}
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}
