package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_bj_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static boolean[] v;
	static int ans = 0;
	static int cnt = 0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static void dfs(int r, int c, int cnt) {
		v[map[r][c]-'A'] = true;
		ans = Math.max(ans, cnt);
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0&&nr<R&&nc>=0&&nc<C&&!v[map[nr][nc]-'A']) {
				dfs(nr, nc, cnt+1);
				//v[map[nr][nc]-'A'] = false;
			}
		}
		v[map[r][c]-'A'] = false;
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new char[R][C];
    	v = new boolean[26];
    	for(int i=0; i<R; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	dfs(0,0,1);
        System.out.println(ans);
        br.close();
    }
}
