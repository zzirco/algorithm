package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_10971_외판원순회2 {
	static int N;
	static int[][] g;
	static boolean[] v;
	static int cost;
	static int[] a, b;
	static void perm(int cnt, int curCost) {
		if(cnt==N) {
			int start = b[0];
			int end = b[N-1];
			if(g[end][start]==0) return;
			curCost += g[end][start];
			cost = Math.min(cost, curCost);
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			if(cnt!=0) {
				if(g[b[cnt-1]][a[i]]==0) continue;
				curCost += g[b[cnt-1]][a[i]];
			}
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1, curCost);
			v[i] = false;
			if(cnt>0) {
				curCost -= g[b[cnt-1]][b[cnt]];
			}
		}
	} 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new int[N][N];
		v = new boolean[N];
		a = new int[N];
		b = new int[N];
		cost = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a[i] = i;
			for(int j=0; j<N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0,0);
		System.out.println(cost);
	}
}
