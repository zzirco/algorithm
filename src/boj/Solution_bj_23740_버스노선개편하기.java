package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_bj_23740_버스노선개편하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<long[]> q = new PriorityQueue<>((o1,o2)->Long.compare(o1[0], o2[0]));
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			q.offer(new long[] {start, end, cost});
		}
		long[] cur = q.poll();
		long l = cur[0];
		long r = cur[1];
		long c = cur[2];
		int cnt = 0;
		if(N==1) {
			System.out.println(++cnt);
			System.out.println(l + " " + r + " " + c + "\n");
			return;
		}
		for(int i=1; i<N; i++) {
			long[] next = q.poll();
			if(r<next[0]) {
				sb.append(l + " " + r + " " + c + "\n");
				l = next[0];
				r = next[1];
				c = next[2];
				cnt++;
			} else {
				if(r<next[1]) r = next[1];
				c = Math.min(c, next[2]);
			}
		}
		sb.append(l + " " + r + " " + c + "\n");
		System.out.println(++cnt);
		System.out.println(sb);
		br.close();
	}
}
