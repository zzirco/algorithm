package a0221.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_3289_서로소집합_서울_20반_신호준 {
	static int[] parent;
	static int[] rank;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_3289.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	parent = new int[N+1];
        	rank = new int[N+1];
        	for(int i=1; i<N+1; i++) {
        		parent[i] = i;
        		rank[i] = 0;
        	}
        	sb.append("#"+tc+" ");
        	for(int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int order = Integer.parseInt(st.nextToken());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		switch(order) {
        		case 0: 
        			union(x, y);
        			break;
        		case 1:
        			if(find(x)==find(y)) sb.append(1);
        			else sb.append(0);
        			break;
        		}
        	}
        	sb.append("\n");
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
