package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15961_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list = new int[N+k-1];
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<k-1; i++) {
			list[N++] = list[i];
		}

		int[] cnt = new int[d+1];
		int max = 1;
		cnt[c]++;
		for(int i=0; i<k; i++) {
			if(cnt[list[i]]==0) {
				max++;
			}
			cnt[list[i]]++;
		}
		
		int start = 0;
		int end = k;
		int result = max;
		for(int i=end; i<list.length; i++) {
			cnt[list[start]]--;
			if(cnt[list[start]]==0) result--;
			if(cnt[list[i]]==0) result++;
			cnt[list[i]]++;
			max = Math.max(max, result);
			start++;
		}
		System.out.println(max);
		br.close();
	}
}
