package boj;

import java.io.*;
import java.util.*;

public class Solution_bj_1976_여행가자 {
	static int N;
	static int[] p;
	
	static void make() {
		p = new int[N+1];
		for(int i=1; i<N+1; i++) p[i]=i;
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
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		make();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		for(int i=1; i<M; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(find(start)!=find(next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
