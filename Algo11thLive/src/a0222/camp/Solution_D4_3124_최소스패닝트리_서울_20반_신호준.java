package a0222.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리_서울_20반_신호준 {
	static int V;
	static int[][] g;
	static int[] p;
	static int[] rank;
	
	static void make() {
		p = new int[V+1];
		rank = new int[V+1];
		for(int i=1; i<V+1; i++) {
			p[i]=i;
			rank[i] = 0;
		}
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		if(rank[a]>rank[b]) p[b] = a;
    	else if(rank[a]<rank[b]) p[a] = b;
    	else {
    		p[b] = a;
    		rank[a]++;
    	}
		return true;
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_3124.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	g = new int[E][3];
    		for(int i=0; i<E; i++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			int from = Integer.parseInt(st.nextToken());
    			int to = Integer.parseInt(st.nextToken());
    			int weight = Integer.parseInt(st.nextToken());
    			g[i] = new int[] {from,to,weight};
    		}
    		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
    		make();
    		int cnt = 0;
    		long result = 0;
    		for(int[] edge:g) {
    			if(union(edge[0],edge[1])) {
    				result += edge[2];
    				if(++cnt==V-1) break;
    			}
    		}
    		sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
