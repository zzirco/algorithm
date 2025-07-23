package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_bj_1916_최소비용구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] g = new ArrayList[N];
		int[] dist = new int[N];
		boolean[] v = new boolean[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			g[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,weight});
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		for(int i=0; i<N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start,dist[start]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			for(int[] vertex:g[minVertex]) {
				if(!v[vertex[0]]&&dist[vertex[0]]>min+vertex[1]) {
					dist[vertex[0]]=min+vertex[1];
					pq.offer(new int[] {vertex[0],dist[vertex[0]]});
				}
			}
		}
		System.out.println(dist[end]);
		br.close();
	}
}
