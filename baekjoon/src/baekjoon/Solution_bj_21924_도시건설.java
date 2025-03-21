package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_21924_도시건설 {
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[M][3];
		long total = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from, to, weight};
			total += weight;
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		long result = 0;
		int cnt = 0;
		boolean flag = false;
		for(int[] edge:g) {
			if(union(edge[0], edge[1])) {
				result += edge[2];
				cnt++;
				if(cnt==N-1) {
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			System.out.println(total-result);
		} else {
			System.out.println(-1);
		}
	}
}
