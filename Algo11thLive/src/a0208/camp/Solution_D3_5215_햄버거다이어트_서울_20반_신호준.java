package a0208.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_5215_햄버거다이어트_서울_20반_신호준 {
	static int N, L;
    static int[][] input;
    static int ans;
     
    static void comb(int cnt, int sum1, int sum2) {
    	if(sum2>L) return;
        if(cnt==N) {
        	if(sum1>ans) {
        		ans = sum1;
        	}
        	return;
        }
        comb(cnt+1, sum1+input[cnt][0], sum2+input[cnt][1]);
        comb(cnt+1, sum1, sum2);
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d3_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            input = new int[N][2];
            ans = Integer.MIN_VALUE;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<2; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0,0,0);
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
}
