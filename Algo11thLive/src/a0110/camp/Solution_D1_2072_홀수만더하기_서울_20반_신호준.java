package a0110.camp;

import java.io.*;
import java.util.*;

public class Solution_D1_2072_홀수만더하기_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ans = 0;
			int[] arr = new int[10];
			int i = 0;
			while (st.hasMoreTokens()) {
				arr[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			for (int j=0; j<arr.length; j++) {
				if (arr[j]%2==1) {
					ans += arr[j];
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
