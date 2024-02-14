package a0214.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D4_11446_사탕가방_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_11446.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.valueOf(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            long candy[] = new long[N];
            long max = Long.MIN_VALUE;
            for(int i=0; i<N; i++) {
                candy[i] = Long.parseLong(st.nextToken());
                max = Math.max(max, candy[i]);
            }
            long start = 1L;
            long end = max;
            while(start<=end) {
            	long mid = (start+end)/2;
            	long sum = 0L;
                for(int i=0; i<N; i++) 
                    sum += (candy[i]/mid);
                if(sum<M) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            sb.append("#"+tc+" "+end+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
