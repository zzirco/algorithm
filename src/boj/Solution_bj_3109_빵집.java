package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_bj_3109_빵집 {
	static int R, C;
	static char[][] map;
	static int cnt = 0;
	static boolean dfs(int r, int c) {
		map[r][c] = '-';
		if(c==C-1) return true;
		if(r>0&&map[r-1][c+1]=='.') {
			if(dfs(r-1,c+1)) return true;
		} if(map[r][c+1]=='.') {
			if(dfs(r,c+1)) return true;
		} if (r+1<R&&map[r+1][c+1]=='.') {
			if(dfs(r+1,c+1)) return true;
		} return false;
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new char[R][C];
    	for(int i=0; i<R; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	for(int r=0; r<R; r++) {
    		if(dfs(r,0)) cnt++;
    	}
        System.out.println(cnt);
        br.close();
    }
}
