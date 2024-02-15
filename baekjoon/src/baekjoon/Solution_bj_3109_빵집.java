package baekjoon;

import java.io.*;
import java.util.*;
 
public class Solution_bj_3109_빵집 {
	static int R, C;
	static int[][] map;
	static int[][] copy;
	static int[] arr;
	static int ans = Integer.MIN_VALUE;
	static int cnt = 0;
	static boolean v = false;
	static void dfs(int r, int c) {
//		if(r==R) {
//			ans = Math.max(ans, cnt);
//			cnt=0;
//			return;
//		}
		if(v) return;
		if(c==C-1) {
			copy[r][c]=1;
			cnt++;
			for(int i=0; i<copy.length; i++) {
				map[i] = copy[i].clone();
			}
			//dfs(r+1,0);
			v = true;
			return;
		}
		if(copy[r][c]==0) {
			for(int i=-1; i<2; i++) {
				copy[r][c]=1;
				if(possible(r+i,c+1)) {
					dfs(r+i,c+1);
					//return;
				} else {
					copy[r][c]=0;
				}
			}
			copy[r][c]=0;
			return;
		}
	}
	static boolean possible(int r, int c) {
		if(r>=0&&r<R&&c>=0&&c<C) {
			if(copy[r][c]!=0) return false;
			return true;
		} else {
			return false;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new int[R][C];
    	copy = new int[R][C];
    	for(int i=0; i<R; i++) {
    		String s = br.readLine();
    		String[] sa = s.split("");
    		for(int j=0; j<C; j++) {
    			if(sa[j].equals(".")) {
    				map[i][j] = 0;
    			} else {
    				map[i][j] = 2;
    			}
    		}
    	}
    	for(int r=0; r<R; r++) {
    		v = false;
    		for(int i=0; i<map.length; i++) {
    			copy[i] = map[i].clone();
    		}
    		dfs(r,0);
    	}
        System.out.println(cnt);
        br.close();
    }
}
