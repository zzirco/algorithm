package a0206.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_9229_한빈이와SpotMart_서울_20반_신호준 {
	static int N, R=2, C=0;
	static int[] a, b;
	static ArrayList<Integer> list;
	
	private static void comb(int cnt, int start) {
    	if(cnt == R) {
    		int sum = 0;
    		for(int item:b) {
    			sum += item;
    		}
    		list.add(sum);
    		//System.out.println(Arrays.toString(b));
    		C++;
    		return;
    	}
    	for(int i=start; i<N; i++) {
    		b[cnt] = a[i];
    		comb(cnt+1, i+1);
    	}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			a = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			b = new int[R];
			list = new ArrayList<>();
			comb(0,0);
			int min = Integer.MAX_VALUE;
			int ans = -1;
			for(int i=0; i<list.size(); i++) {
				int abs = M-list.get(i);
				if(abs<0) continue;
				if(min>abs) {
					min = abs;
					ans = list.get(i);
				}
			}
			if(ans==Integer.MAX_VALUE) {
				sb.append("#"+tc+" "+"-1\n");
			} else {
				sb.append("#"+tc+" "+ans+"\n");
			}
		}
		System.out.println(sb);
	}
}
