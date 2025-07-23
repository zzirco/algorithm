package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {
    static int k;
    static int[] arr, tmp;
    static StringBuilder sb = new StringBuilder();
    static void comb(int start, int cnt) {
        if(cnt==6) {
            for(int num:tmp) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=start; i<k; i++) {
            tmp[cnt] = arr[i];
            comb(i+1, cnt+1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            arr = new int[k];
            tmp = new int[6];
            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

