package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_7044_BadCowtractors {
	static int N, M;
	static int[] p;
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		p[b] = a;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
			for(int i=0; i<N-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int from = st.nextToken().charAt(0)-'A';
				int size = Integer.parseInt(st.nextToken());
				for(int j=0; j<size; j++) {
					int to = st.nextToken().charAt(0)-'A';
					int weight = Integer.parseInt(st.nextToken());
					q.offer(new int[] {from, to, weight});
				}
			}
			make();
			int result = 0, cnt = 0;
			while(!q.isEmpty()) {
				int[] edge = q.poll();
				if(union(edge[0], edge[1])) {
					result += edge[2];
					if(++cnt==N-1) break;
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
