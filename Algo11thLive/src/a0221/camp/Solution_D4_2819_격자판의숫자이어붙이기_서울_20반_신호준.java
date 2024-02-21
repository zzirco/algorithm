package a0221.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_2819_격자판의숫자이어붙이기_서울_20반_신호준 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static String[][] arr;
	static HashSet<String> ans;
	static void dfs(int i, int j, int cnt, String s) {
		if(cnt==6) {
			ans.add(s);
			return;
		}
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&ni<4&&nj>=0&&nj<4) {
				dfs(ni,nj,cnt+1,s+arr[ni][nj]);
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_2819.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	arr = new String[4][4];
        	ans = new HashSet<>();
        	for(int i=0; i<4; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<4; j++) {
        			arr[i][j] = st.nextToken();
        		}
        	}
        	for(int i=0; i<4; i++) {
        		for(int j=0; j<4; j++) {
        			String s = arr[i][j];
        			dfs(i,j,0,s);
        		}
        	}
        	sb.append("#"+tc+" "+ans.size()+"\n");
        }
        System.out.println(sb);
    }
}
