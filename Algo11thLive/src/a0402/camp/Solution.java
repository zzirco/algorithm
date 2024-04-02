package a0402.camp;

import java.io.*;
import java.util.*;

public class Solution {
	static long number[], result,start, end, mul;
	static void cal(long a) {
		for (long i = a; i > 0; i /= 10) {
			number[(int)(i % 10)] += mul;		
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5604.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= test; t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			number = new long[10];
			result = 0;
			mul = 1;
			while (start <= end) {
				while(start%10!=0 && start<=end) {
					cal(start);
					start++;
				}
				while(end%10!=9 && start<=end) {
					cal(end);
					end--;
				}
				if(start>end) break;
				start/=10;
				end/=10;
				for(int i=0;i<10;i++)
					number[i]+=(end-start+1)*mul;
				mul*=10;
			}		
			for (int i = 1; i < 10; i++)
				result += (i * number[i]);
			System.out.println("#" + t + " " + result);
		}
	}
}