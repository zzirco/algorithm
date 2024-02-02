package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2164_카드2 {
	static ArrayList<Integer> sumarr = new ArrayList<>(), mularr = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		while(true) {
			if(queue.size()==1) {
				break;
			}
			queue.poll();
			int num = queue.poll();
			queue.offer(num);
		}
		System.out.println(queue.poll());
	}
}
