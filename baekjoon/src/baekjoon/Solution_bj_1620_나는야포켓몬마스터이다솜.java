package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> h1 = new HashMap<>();
		HashMap<String, Integer> h2 = new HashMap<>();
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			h1.put(i+1, s);
			h2.put(s, i+1);
		}
		for(int i=0; i<M; i++) {
			String order = br.readLine();
			if(order.chars().allMatch(Character::isDigit)) sb.append(h1.get(Integer.parseInt(order))+"\n");
			else sb.append(h2.get(order)+"\n");
		}
		System.out.println(sb);
	}
}
