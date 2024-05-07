package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_6593_상범빌딩 {
	static final int[] dl = {-1,1,0,0,0,0};
	static final int[] di = {0,0,-1,1,0,0};
	static final int[] dj = {0,0,0,0,-1,1};
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] v;
	static boolean escape;
	static int ans;
	static Queue<int[]> q;
	static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int l = cur[0];
			int i = cur[1];
			int j = cur[2];
			int cnt = cur[3];
			if(map[l][i][j]=='E') {
				escape = true;
				ans = cnt;
				return;
			}
			for(int d=0; d<6; d++) {
				int nl = l + dl[d];
				int ni = i + di[d];
				int nj = j + dj[d];
				if(nl>=0&&nl<L&&ni>=0&&ni<R&&nj>=0&&nj<C&&!v[nl][ni][nj]&&map[nl][ni][nj]!='#') {
					v[nl][ni][nj] = true;
					q.offer(new int[] {nl,ni,nj,cnt+1});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0&&R==0&&C==0) break;
			map = new char[L][R][C];
			v = new boolean[L][R][C];
			escape = false;
			ans = 0;
			q = new ArrayDeque<>();
			for(int l=0; l<L; l++) {
				for(int i=0; i<R; i++) {
					String[] sa = br.readLine().split("");
					for(int j=0; j<C; j++) {
						map[l][i][j] = sa[j].charAt(0);
						if(map[l][i][j]=='S') {
							q.offer(new int[] {l,i,j,0});
							v[l][i][j] = true;
						}
					}
				}
				br.readLine();
			}
			bfs();
			if(escape) sb.append("Escaped in "+ans+" minute(s).\n");
			else sb.append("Trapped!\n");
		}
		System.out.println(sb);
	}
}
