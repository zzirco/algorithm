package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9663 {
    static int N;
    static boolean[] v1;
    static boolean[] v2;
    static boolean[] v3;
    static int ans = 0;
    static void queen(int i) {
        if(i==N) {
            ans++;
            return;
        }
        for(int j=0; j<N; j++) {
            if(v1[j]||v2[i+j]||v3[i-j+N-1]) continue;
            v1[j] = true;
            v2[i+j] = true;
            v3[i-j+N-1] = true;
            queen(i+1);
            v1[j] = false;
            v2[i+j] = false;
            v3[i-j+N-1] = false;
        }
    }
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v1 = new boolean[40];
        v2 = new boolean[40];
        v3 = new boolean[40];
        queen(0);
        System.out.println(ans);
    }
}
