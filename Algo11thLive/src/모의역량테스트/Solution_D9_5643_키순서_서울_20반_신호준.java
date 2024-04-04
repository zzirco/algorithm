package 모의역량테스트;

import java.io.*;
import java.util.*;
 
public class Solution_D9_5643_키순서_서울_20반_신호준 {
	static int N, M, cnt, ans;
	public static void dfs(int i, int[][]g, boolean[] v) {
		v[i] = true;
		for(int j=1; j<=N; j++) {
			if(g[i][j]==1&&!v[j]) {
				cnt++;
				dfs(j,g,v);
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_5643.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	M = Integer.parseInt(br.readLine());
        	int[][] g = new int[N+1][N+1];
        	int[][] rg = new int[N+1][N+1];
        	ans = 0;
        	for(int i=0; i<M; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		int r = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		g[r][c] = rg[c][r] = 1;
        	}
        	for(int i=1; i<=N; i++) {
        		cnt = 0;
        		dfs(i,g,new boolean[N+1]);
        		dfs(i,rg,new boolean[N+1]);
        		if(cnt==N-1) ans++;
        	}
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
}
