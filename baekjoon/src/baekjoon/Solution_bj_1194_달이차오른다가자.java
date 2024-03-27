package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1194_달이차오른다가자 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static char[][] map;
	static boolean[][][] v;
	static int ans;
	static int bfs(int i, int j, int cnt, int curKey) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt+1,curKey});
		v[i][j][curKey] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			curKey = ij[3];
			if(map[i][j]=='1') {
				return cnt-1;
			}
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni<0||ni>=N||nj<0||nj>=M) continue;
				if(v[ni][nj][curKey]||map[ni][nj]=='#') continue;
				if(map[ni][nj]>='a'&&map[ni][nj]<='f') {
					int nextKey = 1<<(map[ni][nj]-'a');
					nextKey |= curKey;
					v[ni][nj][nextKey] = true;
					v[ni][nj][curKey] = true;
					q.offer(new int[] {ni,nj,cnt+1,nextKey});
				} else if(map[ni][nj]>='A'&&map[ni][nj]<='F') {
					if((curKey&1<<(map[ni][nj]-'A'))==(int)Math.pow(2, map[ni][nj]-'A')) {
						v[ni][nj][curKey] = true;
						q.offer(new int[] {ni,nj,cnt+1,curKey});
					}
				} else {
					v[ni][nj][curKey] = true;
					q.offer(new int[] {ni,nj,cnt+1,curKey});
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M][64];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int si=0, sj=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') {
					si = i;
					sj = j;
				}
			}
		}
		System.out.println(bfs(si,sj,0,0));
	}
}
