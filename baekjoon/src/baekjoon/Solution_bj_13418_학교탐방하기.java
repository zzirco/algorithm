package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_13418_학교탐방하기 {
	static int N, M;
	static int[][] g;
	static int[] p;
	static void make() {
		p = new int[N+1];
		for(int i=0; i<N+1; i++) p[i] = i;
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		p[b] = a;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[M+1][3];
		for(int i=0; i<M+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from, to, weight};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		long result1 = 0;
		int cnt = 0;
		for(int[] edge:g) {
			if(union(edge[0],edge[1])) {
				result1 += edge[2];
				if(++cnt==N) break;
			}
		}
		result1 = N - result1;
		Arrays.sort(g,(o1,o2)->Integer.compare(o2[2], o1[2]));
		make();
		long result2 = 0;
		cnt = 0;
		for(int[] edge:g) {
			if(union(edge[0],edge[1])) {
				result2 += edge[2];
				if(++cnt==N) break;
			}
		}
		result2 = N - result2;
		System.out.println(result1*result1-result2*result2);
		br.close();
	}
}
