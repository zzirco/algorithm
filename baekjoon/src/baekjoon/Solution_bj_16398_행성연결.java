package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16398_행성연결 {
	static int N;
	static int[][] g;
	static int[] p;
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = i;
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
		N = Integer.parseInt(br.readLine());
		g = new int[N*(N-1)/2][3];
		int idx = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<i; j++) {
				if(i==j) continue;
				int weight = Integer.parseInt(st.nextToken());
				g[idx++] = new int[] {i, j, weight};
			}
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		long result = 0;
		int cnt = 0;
		for(int[] edge:g) {
			if(union(edge[0],edge[1])) {
				result += edge[2];
				if(++cnt==N-1) break;
			}
		}
		System.out.println(result);
		br.close();
	}
}
