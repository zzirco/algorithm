package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int start = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = start; j <= num; j++) {
                stack.push(j);
                sb.append("+").append("\n");
            }
            start = Math.max(start, num+1);
            if(stack.peek()==num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
