package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1241 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0; i<N; i++) {
            int cur = arr[i];
            int sqrt = (int)Math.sqrt(cur);
            int cnt = sqrt*sqrt==cur?-map.getOrDefault(sqrt,0):0;
            for(int j=1; j<=sqrt; j++) {
                if(cur%j!=0) continue;
                cnt += map.getOrDefault(j,0) + map.getOrDefault(cur/j,0);
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.println(sb);
    }
}
