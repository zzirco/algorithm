package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_13913 {
	static int[] di = {-1,1,2};
	static int N, K;
	static int[] map;
	static boolean[] v;
	static int min = Integer.MAX_VALUE;
	
	static void bfs(int i, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,cnt});
		v[i] = true;
		map[i] = i;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			cnt = cur[1];
			if(i==K) {
				min = Math.min(min, cnt);
				return;
			}
			for(int d=0; d<3; d++) {
				int ni = d==2?(i*di[d]):(i+di[d]);
				if(ni>=0&&ni<=100000&&!v[ni]) {
					v[ni] = true;
					map[ni] = i;
					q.offer(new int[] {ni,cnt+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		v = new boolean[100001];
		bfs(N,0);
		System.out.println(min);
		int next = K;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.offerLast(K);
		while(next!=N) {
			stack.offerLast(map[next]);
			next = map[next];
		}
		while(!stack.isEmpty()) sb.append(stack.pollLast() + " ");
		System.out.println(sb);
	}
}
