package 모의역량테스트;

import java.io.*;
import java.util.*;
 
public class Solution_D9_4012_요리사_서울_20반_신호준 {
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
    	System.setIn(new FileInputStream("res/input_d9_4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
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
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
