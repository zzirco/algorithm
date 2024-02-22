package a0222.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_1238_Contact_서울_20반_신호준 {
	static List<Integer>[] g;
	static boolean[] v;
	static Pair ans;
	static class Pair implements Comparable<Pair> {
		int vertex;
		int depth;
		public Pair(int vertex, int depth) {
			super();
			this.vertex = vertex;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Pair [vertex=" + vertex + ", depth=" + depth + "]";
		}
		@Override
		public int compareTo(Pair o) {
			return (this.depth==o.depth)?Integer.compare(this.vertex, o.vertex):Integer.compare(this.depth, o.depth);
		}
	}
	static void bfs(int i, int cnt) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		v[i]=true;
		q.offer(new Pair(i,cnt));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			i = p.vertex;
			cnt = p.depth;
			if(ans.depth<p.depth) {
				ans = p;
			} else if(ans.depth==p.depth&&ans.vertex<p.vertex) {
				ans = p;
			}
			for(int j:g[i]) {
				if(!v[j]) {
					v[j]=true;
					q.offer(new Pair(j,cnt+1));
				}
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc=1; tc<=10; tc++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int E = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	g = new List[101]; for(int i=0; i<101; i++) g[i] = new ArrayList<>();
        	v = new boolean[101];
        	ans = new Pair(Integer.MIN_VALUE,0);
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<E/2; i++) {
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		for(int j=0; j<E; j++) {
        			g[from].add(to);
        		}
        	}
        	sb.append("#"+tc+" ");
        	bfs(start,0);
        	sb.append(ans.vertex);
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
