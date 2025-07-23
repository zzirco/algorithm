package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_1152_단어의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			cnt++;
		}
		System.out.println(cnt);
	}
}
