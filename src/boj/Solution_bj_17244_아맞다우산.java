package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_17244_아맞다우산 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static int si, sj, ei, ej;
	static char[][] map;
	static boolean[][][] v;
	static int size;
	static void bfs(int i, int j, int cnt, int curKey) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt,curKey});
		v[i][j][curKey] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			cnt = cur[2];
			curKey = cur[3];
			if(map[i][j]=='E'&&curKey==(1<<size)-1) {
				System.out.println(cnt);
				return;
			}
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni<0||ni>=N||nj<0||nj>=M) continue;
				if(map[ni][nj]=='#'||v[ni][nj][curKey]) continue;
				if(map[ni][nj]!='.'&&map[ni][nj]!='S'&&map[ni][nj]!='E') {
					int nextKey = 1<<((int)(map[ni][nj]-'0'));
					nextKey |= curKey;
					v[ni][nj][nextKey] = true;
					v[ni][nj][curKey] = true;
					q.offer(new int[] {ni,nj,cnt+1,nextKey});
				} else {
					q.offer(new int[] {ni,nj,cnt+1,curKey});
					v[ni][nj][curKey] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		size = 0;
		for(int i=0; i<N; i++) {
			String[] sa = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = sa[j].charAt(0);
				if(map[i][j]=='S') {
					si = i;
					sj = j;
				} else if(map[i][j]=='E') {
					ei = i;
					ej = j;
				} else if(map[i][j]=='X') {
					map[i][j] = (char)(size+'0');
					size++;
				}
			}
		}
		v = new boolean[N][M][1<<size];
		bfs(si,sj,0,0);
	}
}
