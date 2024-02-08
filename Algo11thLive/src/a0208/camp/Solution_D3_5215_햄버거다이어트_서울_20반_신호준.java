package a0208.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_5215_햄버거다이어트_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer ST = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(ST.nextToken());
            int L = Integer.parseInt(ST.nextToken());
            int[] tast = new int[N+1];
            int[] kcal = new int[N+1];
            int[][] dp = new int[N+1][L+1];
            for(int n=1; n<=N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                tast[n] = Integer.parseInt(st.nextToken());
                kcal[n] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=L; j++) {
                    if (kcal[i] > j) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-kcal[i]]+tast[i]);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
