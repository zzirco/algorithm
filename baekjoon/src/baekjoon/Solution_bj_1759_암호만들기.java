package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1759_암호만들기 {
	static int N, C;
	static char[] a,b;
	static StringBuilder sb = new StringBuilder();
	static void comb(int cnt, int start) {
		if(cnt==N) {
			int cnt1=0, cnt2=0;
			for(char item:b) {
				if(item=='a'||item=='e'||item=='i'||item=='o'||item=='u') {
					cnt1++;
				} else {
					cnt2++;
				}
			}
			if(cnt1>=1&&cnt2>=2) {
				for(char item:b) {
					sb.append(item);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			b[cnt] = a[i];
			comb(cnt+1,i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		a = new char[C];
		b = new char[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			a[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(a);
		comb(0,0);
		System.out.println(sb);
	}
}
