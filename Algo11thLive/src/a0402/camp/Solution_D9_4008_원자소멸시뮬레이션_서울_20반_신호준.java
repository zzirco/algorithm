package a0402.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_4008_원자소멸시뮬레이션_서울_20반_신호준 {
	static long start, end, pow, cnt[];
	public static void count(long num, long digit) {
		while(num>0) {
			cnt[(int)(num%10)] += digit;
			num /= 10;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5604.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			pow = 1;
			cnt = new long[10];
			while(start <= end) {
				while(start%10!=0&&start<=end) {
					count(start, pow);
					start++;
				}
				while(end%10!=9&&start<=end) {
					count(end, pow);
					end--;
				}
				if(start>end) break;
				start /= 10;
				end /= 10;
				for(int i=0; i<10; i++) {
					cnt[i] += (end-start+1)*pow;
				}
				pow *= 10;
			}
			long sum = 0;
			for(int i=1; i<10; i++) {
				sum += i*cnt[i];
			}
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
