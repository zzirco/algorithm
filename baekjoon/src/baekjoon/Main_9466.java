package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9466 {
	static int N;
	static int[] g;
	static boolean[] v;
	static int bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		v[i] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(g[cur]==cur) cnt--;
			if(!v[g[cur]]) {
				q.offer(g[cur]);
				v[g[cur]] = true;
			}
			cnt++;
			if(g[cur]==i) cnt=0;
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			g = new int[N+1];
			v = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				g[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for(int i=1; i<=N; i++) {
				if(!v[i]) sum += bfs(i);
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
