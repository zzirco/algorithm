package a0130.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_1208_Flatten_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<dump; i++) {
				Arrays.sort(arr);
				if(Math.abs(arr[99]-arr[0])<1) {
					System.out.println(Arrays.toString(arr));
					break;
				}
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			int ans = Math.abs(arr[99]-arr[0]);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
