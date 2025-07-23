package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_bj_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0)+1);
			if(map.get(s)==2) ans.add(s);
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(String s:ans) {
			System.out.println(s);
		}
		br.close();
	}
}
