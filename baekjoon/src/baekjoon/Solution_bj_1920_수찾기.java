package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		long[] arr1 = new long[(int) N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr1[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		long M = Long.parseLong(st.nextToken());
		long[] arr2 = new long[(int) M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			arr2[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr1);
		A:for(int i=0; i<M; i++) {
			long start = 0;
			long end = N-1;
			while(start<=end) {
				long mid = (start+end)/2;
				if(arr1[(int) mid]==arr2[i]) {
					System.out.println(1);
					continue A;
				} else if(arr1[(int) mid]<arr2[i]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			System.out.println(0);
		}
	}
}
