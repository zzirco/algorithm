package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1911 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{start,end});
        }
        int cnt = 0;
        int cur = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int start = node[0];
            int end = node[1];
            if(end<=cur) continue;
            if(start>cur) cur = start;
            int remain = (end - cur) % L;
            cnt += (end - cur) / L;
            cur = end;
            if(remain!=0) {
                cnt++;
                cur += L - remain;
            }
        }
        System.out.println(cnt);
    }
}
