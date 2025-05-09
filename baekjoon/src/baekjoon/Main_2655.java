package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2655 {
	public static class Node implements Comparable<Node> {
		int id;
		int a;
		int h;
		int w;
		public Node(int id, int a, int h, int w) {
			this.id = id;
			this.a = a;
			this.h = h;
			this.w = w;
		}
		@Override
		public int compareTo(Node b) {
			return this.w - b.w;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		list.add(new Node(0,0,0,0));
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Node(i+1,a,h,w));
		}
		Collections.sort(list);
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<i; j++) {
				if(list.get(i).a>list.get(j).a) {
					dp[i] = Math.max(dp[i], dp[j]+list.get(i).h);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=N; i++) {
			if(max<dp[i]) max = dp[i];
		}
		int idx = N;
		ArrayList<Integer> ans = new ArrayList<>();
		while(idx!=0) {
			if(max==dp[idx]) {
				ans.add(list.get(idx).id);
				max -= list.get(idx).h;
			}
			idx--;
		}
		System.out.println(ans.size());
		for(int i=ans.size()-1; i>=0; i--) {
			System.out.println(ans.get(i));
		}
	}
}
