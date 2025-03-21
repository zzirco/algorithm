package baekjoon;

import java.io.*;

public class Solution_bj_5341_Pyramids {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) break;
			int sum = 0;
			for(int i=a; i>=1; i--) {
				sum += i;
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
