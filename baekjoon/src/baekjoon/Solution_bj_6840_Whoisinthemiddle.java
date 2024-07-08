package baekjoon;

import java.util.*;

public class Solution_bj_6840_Whoisinthemiddle {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i=0; i<3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
		sc.close();
	}
}
