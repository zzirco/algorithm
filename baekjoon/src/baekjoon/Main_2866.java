package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[C][R];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
               arr[j][i] = s.charAt(j);
            }
        }
        int start = 0;
        int end = R - 1;
        while(start<=end) {
            int mid = (start + end) / 2;
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<C; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=mid+1; j<R; j++) {
                    sb.append(arr[i][j]);
                }
                set.add(sb.toString());
            }
            if(set.size()!=C) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}
