package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_5522_카드게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<5; i++) {
			int cur = Integer.parseInt(br.readLine());
			sum += cur;
		}
		System.out.println(sum);
	}
}
