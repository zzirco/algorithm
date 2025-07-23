package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution_bj_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> t = new TreeSet<>();
		for(int i=0; i<N; i++) {
			t.add(Integer.parseInt(br.readLine()));
		}
		int size = t.size();
		for(int i=0; i<size; i++) {
			sb.append(t.pollFirst()+"\n");
		}
		System.out.println(sb);
	}
}
