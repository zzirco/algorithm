package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_11729_하노이탑이동순서 {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void hanoi(int N, int from, int tmp, int target) {
		if(N==0) {
			return;
		}
		hanoi(N-1, from, target, tmp);
		cnt++;
		sb.append(from+" "+target+"\n");
		hanoi(N-1, tmp, from, target);
	}
}
