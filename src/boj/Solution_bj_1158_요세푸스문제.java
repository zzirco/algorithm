package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_bj_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		Queue<Integer> ans = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		int index = 0;
		int cnt = 1;
		while(!list.isEmpty()) {
			if(index>list.size()-1) index = 0;
			if(cnt==K) {
				ans.add(list.get(index));
				list.remove(list.get(index));
				cnt = 1;
			} else {
				index++;
				cnt++;
			}
		}
		sb.append("<");
		for(int i:ans) {
			sb.append(i+", ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}
