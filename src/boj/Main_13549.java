package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_13549 {
	static int[] di = {2,-1,1};
	static int N, K;
	static int[] map;
	static boolean[] v;
	static int ans = 0;

	static void bfs(int i, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int [] {i, cnt});
		v[i] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			cnt = cur[1];
			if(i==K) {
				ans = cnt;
				return;
			}
			for(int d=0; d<3; d++) {
				if(d==0) {
					int ni = i*di[d];
					if(ni>=0&&ni<100001&&!v[ni]) {
						v[ni] = true;
						map[ni] = cnt;
						q.offer(new int[]{ni,cnt});
					}
				}
				else {
					int ni = i+di[d];
					if(ni>=0&&ni<100001&&!v[ni]) {
						v[ni] = true;
						map[ni] = cnt+1;
						q.offer(new int[]{ni,cnt+1});
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		v = new boolean[100001];
		bfs(N,0);
		System.out.println(ans);
	}
}