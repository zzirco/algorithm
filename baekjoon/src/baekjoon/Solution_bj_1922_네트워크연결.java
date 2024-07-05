package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1922_네트워크연결 {
	static int N, M;
	static int[][] g;
	static int[] p;
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
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
		p[b] = a;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		g = new int[M][3];
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from, to, weight};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		int result = 0;
		int cnt = 0;
		for(int[] edge:g) {
			if(union(edge[0], edge[1])) {
				result += edge[2];
				cnt++;
				if(cnt==N-1) break;
			}
		}
		System.out.println(result);
	}
}
