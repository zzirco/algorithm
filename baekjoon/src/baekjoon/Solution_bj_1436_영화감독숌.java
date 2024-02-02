package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int numCount = 1;
		String num = Integer.toString(numCount);
		int cnt = 0;
		while(true) {
			if(cnt==N) {
				break;
			}
			if(num.contains("666")) {
				cnt++;
			}
			numCount++;
			num = Integer.toString(numCount);
		}
		System.out.println(numCount-1);
	}
}
