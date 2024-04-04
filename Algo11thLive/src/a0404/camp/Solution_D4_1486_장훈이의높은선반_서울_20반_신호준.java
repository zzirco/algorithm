package a0404.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D4_1486_장훈이의높은선반_서울_20반_신호준 {
	static int N, B;
	static int[] arr;
	static int ans;
	public static void sol(int cnt, int sum) {
		if(sum>=B) {
			ans = Math.min(ans, sum);
			return ;
		}
		if(cnt==N) return;
		sol(cnt+1, sum+arr[cnt]);
		sol(cnt+1, sum);
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_1486.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	arr = new int[N];
        	ans = Integer.MAX_VALUE;
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	sol(0,0);
        	sb.append("#"+tc+" "+(ans-B)+"\n");
        }
        System.out.println(sb);
    }
}
