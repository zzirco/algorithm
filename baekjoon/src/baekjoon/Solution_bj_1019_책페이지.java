package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1019_책페이지 {
	static int start, end, digit;
	static int[] cnt;
	public static void counting(int num, int digit) {
		while(num > 0) {
			cnt[num % 10] += digit;
			num /= 10;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = 1;
		end = Integer.parseInt(st.nextToken());
		digit = 1;
		cnt = new int[10];
		while(start <= end) {
			while(start % 10 != 0 && start <= end) {
				counting(start, digit);
				start++;
			}
			while(end % 10 != 9 && start <= end) {
				counting(end, digit);
				end--;
			}
			if(start > end) break;
			start /= 10;
			end /= 10;
			for(int i = 0 ; i < 10 ; ++i) {
				cnt[i] += (end - start + 1) * digit;
			}
			digit *= 10;
		}
		for(int i=0; i<cnt.length; i++) {
			sb.append(cnt[i]+" ");
		}
		System.out.println(sb);
	}
}
