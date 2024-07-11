package baekjoon;

import java.io.*;
 
public class Solution_bj_9086_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	String[] sa = br.readLine().split("");
        	sb.append(sa[0]+sa[sa.length-1]+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}