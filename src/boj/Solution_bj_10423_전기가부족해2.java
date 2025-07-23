package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_bj_10423_전기가부족해2 {
	static int N, M, K;
	static int[][] g;
	static int[] p;
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = i;
	}
	static int find(int a) {
		if(a==-1) return -1;
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		if(a==-1) p[b] = a;
		else p[a] = b;
		return true;
	}
	static boolean done() {
		for(int i=0; i<N; i++) {
			if(p[i]!=-1) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		g = new int[M][3];
		int[] elc = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<K; i++) {
			elc[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from, to, weight};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		for(int i=0; i<K; i++) {
			p[elc[i]-1] = -1;
		}
		long result = 0;
		for(int[] edge:g) {
			if(union(edge[0],edge[1])) {
				result += edge[2];
				if(done()) break;
			}
		}
		System.out.println(result);
		br.close();
	}
}
