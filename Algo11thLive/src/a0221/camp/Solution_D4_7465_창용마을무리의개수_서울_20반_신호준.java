package a0221.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_7465_창용마을무리의개수_서울_20반_신호준 {
	static int[] parent;
	static int[] rank;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_7465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	parent = new int[N+1];
        	rank = new int[N+1];
        	int[] cnt = new int[N+1];
        	int ans = 0;
        	for(int i=1; i<N+1; i++) {
        		parent[i] = i;
        		rank[i] = 0;
        	}
        	for(int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		union(x,y);
        	}
        	for(int i=1; i<N+1; i++) {
        		cnt[find(i)]++;
        	}
        	for(int i:cnt) {
        		if(i!=0) ans++;
        	}
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
    static boolean union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x==y) return false;
    	if(rank[x]>rank[y]) parent[y] = x;
    	else if(rank[x]<rank[y]) parent[x] = y;
    	else {
    		parent[y] = x;
    		rank[x]++;
    	}
    	return true;
    }
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
}
