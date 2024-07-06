package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1911_흙길보수하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		PriorityQueue<long[]> q = new PriorityQueue<>((o1,o2)->Long.compare(o1[0], o2[0]));
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			q.offer(new long[] {start, end});
		}
		long[] cur = q.poll();
		long l = cur[0];
		long r = cur[1];
		long sum = 0;
		if(N==1) {
			if((r-l)%L!=0) sum = sum / L + 1;
			System.out.println(sum);
			return;
		}
		for(int i=1; i<N; i++) {
			long[] next = q.poll();
			if(r<next[0]) {
				sum += r - l;
				l = next[0];
				r = next[1];
			} else {
				if(r<next[1]) r = next[1];
			}
		}
		sum += r - l;
		if(sum%L!=0) sum = sum / L + 1;
		System.out.println(sum);
		br.close();
	}
}
