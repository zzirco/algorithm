package 모의역량테스트;

import java.io.*;
import java.util.*;
 
public class Solution_D9_1953_탈주범검거_서울_20반_신호준 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int[][] tunnel = { //상우하좌
			{0,0,0,0},
			{1,1,1,1},
			{1,0,1,0},
			{0,1,0,1},
			{1,1,0,0},
			{0,1,1,0},
			{0,0,1,1},
			{1,0,0,1},
	};
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] v;
	static int ans;
	public static void bfs(int i, int j, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j, cnt});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			if(cnt==L-1) continue;
			for(int d=0; d<4; d++) {
				if(tunnel[map[i][j]][d]==0) continue;
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&map[ni][nj]!=0) {
					if(tunnel[map[ni][nj]][(d+2)%4]==1) {
						v[ni][nj] = true;
						ans++;
						q.offer(new int[] {ni,nj,cnt+1});
					}
				}
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_1953.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	L = Integer.parseInt(st.nextToken());
        	map = new int[N][M];
        	v = new boolean[N][M];
        	ans = 1;
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<M; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	bfs(R,C,0);
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
}
