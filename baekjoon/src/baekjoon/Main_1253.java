package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0; i<N; i++) {
            int start = 0;
            int end = N-1;
            while(start<end) {
                if(start!=i&&end!=i) {
                    if(arr[start]+arr[end]==arr[i]) {
                        cnt++;
                        break;
                    } else if(arr[start]+arr[end]>arr[i]) end--;
                    else start++;
                } else if(start==i) start++;
                else end--;
            }
        }
        System.out.println(cnt);
    }
}
