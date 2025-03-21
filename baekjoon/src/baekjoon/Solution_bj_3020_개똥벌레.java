package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_3020_개똥벌레 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] tmp = new int[H];
		for(int i=0; i<N; i++) {
			int len = Integer.parseInt(br.readLine());
			int start, end;
			if(i%2!=0) {
				start = H - len;
				end = H - 1;
			} else {
				start = 0;
				end = len - 1;
			}
			int height = 1;
			tmp[start] = tmp[start] + height;
			if(end+1<H) {
				tmp[end+1] = tmp[end+1] - height;
			}
		}
		for(int i=1; i<H; i++) {
			tmp[i] = tmp[i-1] + tmp[i];
		}
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i=0; i<H; i++) {
			if(min>tmp[i]) {
				cnt = 0;
				min = tmp[i];
			}
			if(tmp[i]==min) cnt++;
		}
		
		System.out.println(min+" "+cnt);
	}
}
