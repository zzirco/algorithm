package boj;

import java.io.*;
import java.util.*;

public class Main_1476 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 1;
        while(true) {
            if((ans-E)%15==0&&(ans-S)%28==0&&(ans-M)%19==0) break;
            ans++;
        }
        System.out.println(ans);
    }
}
