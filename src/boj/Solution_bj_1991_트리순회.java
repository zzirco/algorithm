package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_1991_트리순회 {
	static int N;
	static int[][] g;
	static boolean[] v;
	static ArrayDeque<Character> s;
	static ArrayDeque<Character> tmp;
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A'));
		for(int j=0; j<N; j++) {
			if(g[i][j]!=0&&!v[j]) {
				dfs(j);
			}
		}
	}
	static void dfs2(int i) {
		v[i] = true;
		tmp.push((char)(i+'A'));
		for(int j=0; j<N; j++) {
			if(g[i][j]!=0&&!v[j]) {
				dfs2(j);
			}
		}
		s.addAll(tmp);
		tmp.clear();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new int[N][N];
		v = new boolean[N];
		s = new ArrayDeque<>();
		tmp = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int from = st.nextToken().charAt(0)-'A';
			 int to1 = (int)st.nextToken().charAt(0);
			 int to2 = (int)st.nextToken().charAt(0);
			 if(to1!='.') {
				 to1 -= 'A';
				 g[from][to1] = 1;
				 g[to1][from] = 1;
			 }
			 if(to2!='.') {
				 to2 -= 'A';
				 g[from][to2] = 1;
				 g[to2][from] = 1;
			 }
		}
		dfs(0);
		v = new boolean[N];
		System.out.println();
		dfs2(0);
		System.out.println(s);
	}
}
