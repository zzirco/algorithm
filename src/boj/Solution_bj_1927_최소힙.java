package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_bj_1927_최소힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int order = Integer.parseInt(br.readLine());
			if(order==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				} else {
					sb.append(q.poll()+"\n");
				}
			} else {
				q.offer(order);
			}
		}
		System.out.println(sb);
	}
}
