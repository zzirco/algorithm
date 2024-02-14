package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_17140_이차원배열과연산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[200][200];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(true) {
			if(arr[r][c]==k) break;
			if(arr.length>=arr[0].length) {
				
			} else {
				
			}
			time++;
		}
		sb.append(time);
		System.out.println(sb);
	}
}
