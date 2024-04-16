package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1167_트리의지름 {
	static int N;
	static ArrayList<int[]>[] list;
	static boolean[] v;
	static int ans = 0, cur = 0;
	public static void dfs(int i) {
		v[i] = true;
		for(int[] ij:list[i]) {
			if(!v[ij[0]]) {
				cur += ij[1];
				dfs(ij[0]);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if(to==-1) break;
				int weight = Integer.parseInt(st.nextToken());
				list[from].add(new int[] {to, weight});
			}
		}
		for(int i=1; i<N+1; i++) {
			v = new boolean[N+1];
			cur = 0;
			dfs(i);
			ans = Math.max(ans, cur);
		}
		System.out.println(ans);
	}
}
