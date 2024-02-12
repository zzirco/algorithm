package baekjoon;

import java.io.*;
import java.util.*;
 
public class Solution_bj_14889_스타트와링크 {
	static int N, R;
	static boolean[] v;
    static int[][] S;
    static int ans = Integer.MAX_VALUE;
    
    private static void comb(int cnt, int start) {
    	if(cnt == R) {
    		int sum1=0, sum2=0;
    		for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(v[i]&&v[j]) {
        				sum1 += S[i][j];
        			} else if(!v[i]&&!v[j]) {
        				sum2 += S[i][j];
        			}
        		}
    		}
    		int diff = Math.abs(sum1-sum2);
    		ans = Math.min(ans, diff);
    		return;
    	}
    	for(int i=start; i<N; i++) {
    		v[i] = true;
    		comb(cnt+1, i+1); 
    		v[i] = false;
    	}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
    	N = Integer.parseInt(br.readLine());
    	R = N/2;
    	v = new boolean[N];
    	S = new int[N][N];
    	ans = Integer.MAX_VALUE;
    	for(int i=0; i<N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<N; j++) {
    			S[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	comb(0,0);
    	sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}
