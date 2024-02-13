package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] h = new int[500001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()&&h[stack.peek()]<h[i]) {
				stack.pop();
			}
			if(!stack.isEmpty()) sb.append(stack.peek()+1+" ");
			else sb.append(0+" ");
			stack.push(i);
		}
		System.out.println(sb);
	}
}
