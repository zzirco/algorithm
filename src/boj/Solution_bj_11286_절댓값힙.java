package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_bj_11286_절댓값힙 {
	static class Pair {
		int abs;
		int num;
		public Pair(int abs, int num) {
			this.abs = abs;
			this.num = num;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o1.abs==o2.abs?Integer.compare(o1.num, o2.num):Integer.compare(o1.abs, o2.abs));
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				pq.offer(new Pair(Math.abs(num),num));
			} else {
				if(pq.size()==0) {
					sb.append(0+"\n");
				} else {
					sb.append(pq.poll().num+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
