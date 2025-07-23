package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bj_2753_윤년 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if((N%4==0&&N%100!=0)||N%400==0) System.out.println(1);
		else System.out.println(0);
	}
}
