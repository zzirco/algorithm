package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 1;
        int end = arr[N-1] - arr[0] + 1;
        while(start<end) {
            int mid = (start + end) / 2;
            int cur = 0;
            int cnt = 1;
            for(int i=1; i<N; i++) {
                if(arr[i]-arr[cur]>=mid) {
                    cur = i;
                    cnt++;
                }
            }
            if(cnt<C) end = mid;
            else start = mid + 1;
        }
        System.out.println(start-1);
    }
}
