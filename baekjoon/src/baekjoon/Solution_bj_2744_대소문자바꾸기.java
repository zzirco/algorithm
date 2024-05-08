package baekjoon;

import java.io.*;

public class Solution_bj_2744_대소문자바꾸기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		for(int i=0; i<c.length; i++) {
			if(c[i]<95) c[i] = (char)(c[i] + 32);
			else c[i] = (char)(c[i] - 32);
		}
		for(char ch:c) System.out.print(ch);
	}
}
