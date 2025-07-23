package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_bj_2178_미로탐색 {
	static int R, C;
	static int[][] map;
	static boolean[][] v;
	static int ans = Integer.MAX_VALUE;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r,c,1});
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			r = rc[0];
			c = rc[1];
			int cnt = rc[2];
			if(r==R-1&&c==C-1) {
				ans = Math.min(ans, cnt);
				return;
			}
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0&&nr<R&&nc>=0&&nc<C&&!v[nr][nc]&&map[nr][nc]==1) {
					v[nr][nc] = true;
					q.offer(new int[] {nr,nc,cnt+1});
				}
			}
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new int[R][C];
    	v = new boolean[R][C];
    	for(int i=0; i<R; i++) {
    		String[] sa = br.readLine().split("");
    		for(int j=0; j<C; j++) {
    			map[i][j] = Integer.parseInt(sa[j]);
    		}
    	}
    	bfs(0,0);
        System.out.println(ans);
        br.close();
    }
}
