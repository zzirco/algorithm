package boj;

import java.io.*;

public class Main_2439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=N-1; i>=0; i--) {
            for (int j=0; j<i; j++) {
                sb.append(' ');
            }
            for (int j=i; j<N; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
