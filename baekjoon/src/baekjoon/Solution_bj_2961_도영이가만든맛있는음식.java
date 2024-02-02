package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2961_도영이가만든맛있는음식 {
	static int N, sum=0, mul=1;
	static int[] sour, bitter;
	static ArrayList<Integer> sumarr = new ArrayList<>(), mularr = new ArrayList<>();
	static void subs(int cnt, String str, int sum) {
		if (cnt==N) { // 
			//System.out.println("sum: "+sum);
			sumarr.add(sum);
			return;
		}
		subs(cnt+1, str+bitter[cnt], sum+bitter[cnt]);
		subs(cnt+1, str, sum);
	}
	static void subs2(int cnt, String str, int mul) {
		if (cnt==N) { // 
			//System.out.println("mul: "+mul);
			mularr.add(mul);
			return;
		}
		subs2(cnt+1, str+sour[cnt], mul*sour[cnt]);
		subs2(cnt+1, str, mul);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		subs(0, "", 0);
		subs2(0, "", 1);
		//System.out.println(Arrays.toString(sour));
		//System.out.println(sumarr);
		//System.out.println(mularr);
		
		int acc = 0;
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<sumarr.size()-1; i++) {
			acc = Math.abs(mularr.get(i)-sumarr.get(i));
			if(acc<ans) {
				ans = acc;
			}
		}
		System.out.println(ans);
	}
}
