package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_1799_비숍 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] dr = {-1,1,-1,1};
	static int[] dc = {-1,-1,1,1};
	static int N;
	static char[][] arr;
	static boolean[][] v;
	static int ans, ok;
	public static void sol(int i, int j, int cnt) {
		if(cnt==ok) {
			ans = Math.max(ans, cnt);
			return;
		}
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&arr[ni][nj]==1&&!v[ni][nj]) {
				v[ni][nj] = true;
				sol(ni,nj,cnt+1);
				v[ni][nj] = false;
			}
		}
	}
	public static boolean possible(int i, int j) {
		int idx = 0;
		int d = 0;
		while(d<4) {
			int ni = i + idx*dr[d];
			int nj = j + idx*dc[d];
			if(ni<0||ni>=N||nj<0||nj>=N) {
				d++;
				idx = 0;
				continue;
			}
			idx++;
			if(v[ni][nj]==true) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1) ok++;
			}
		}
	}
}
