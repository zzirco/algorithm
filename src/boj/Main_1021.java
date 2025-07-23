package boj;

import java.io.*;
import java.util.*;

public class Main_1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(q.peekFirst()==num) q.pollFirst();
            else {
                int index = q.indexOf(num);
                int middle = q.size() / 2;
                if(index<=middle) {
                    for(int j = 0; j<index; j++){
                        int temp = q.pollFirst();
                        q.addLast(temp);
                        ans++;
                    }
                } else {
                    for(int j = 0; j<q.size()-index; j++){
                        int temp = q.pollLast();
                        q.addFirst(temp);
                        ans++;
                    }
                }
                q.pollFirst();
            }
        }
        System.out.println(ans);
    }
}
