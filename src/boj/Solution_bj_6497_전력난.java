package boj;

import java.io.*;
import java.util.*;

public class Solution_bj_6497_전력난 {
	static int N;
	static int[][] g;
	static int[] p;
	
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i]=i;
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			if(N==0&&E==0) break;
			g = new int[E][3];
			int total = 0;
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				g[i] = new int[] {from,to,weight};
				total += weight;
			}
			Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
			make();
			int result = 0, cnt = 0;
			for(int[] edge:g) {
				if(union(edge[0],edge[1])) {
					result += edge[2];
					if(++cnt==N-1) break;
				}
			}
			sb.append(total-result+"\n");
		}
		System.out.println(sb);
	}
}
