package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466 {
	static int N;
	static int[] g;
	static boolean[] v;
	static boolean[] cycle;
	static int cnt;
	static void dfs(int cur) {
		v[cur] = true;
		int next = g[cur];
		if(!v[next]) dfs(next);
		else {
			if(!cycle[next]) {
				cnt++;
				while(next!=cur) {
					cnt++;
					next = g[next];
				}
			}
		}
		cycle[cur] = true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			g = new int[N+1];
			v = new boolean[N+1];
			cycle = new boolean[N+1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				g[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=N; i++) {
				dfs(i);
			}
			sb.append(N - cnt + "\n");
		}
		System.out.println(sb);
	}
}
