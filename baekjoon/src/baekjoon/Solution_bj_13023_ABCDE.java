package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_13023_ABCDE {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	g = new List[N]; for(int i=0; i<N; i++) g[i] = new ArrayList<>();
		v = new boolean[N];
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		g[from].add(to);
			g[to].add(from);
    	}
    	for(int i=0; i<N; i++) {
    		v = new boolean[N];
    		dfs(i,1);
    	}
    	System.out.println(0);
    }
    static void dfs(int i, int cnt) {
		v[i] = true;
		if(cnt==5) {
			System.out.println(1);
			System.exit(0);
		}
		for(int j:g[i]) {// 0->N
			if(!v[j]) {
				dfs(j,cnt+1);
			}
		}
		v[i] = false;
	}
}
