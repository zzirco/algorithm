package boj;

import java.io.*;
import java.util.*;

public class Main_2539 {
    static int R, C, num, spotCnt;
    public static class Node implements Comparable<Node> {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Node n) {
            return this.c - n.c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(br.readLine());
        spotCnt = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<spotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int left = 1;
        int right = Math.max(R,C);
        while(left<=right) {
            int mid = (left + right) / 2;
            if(check(mid, list)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
    public static boolean check(int mid, ArrayList<Node> list) {
        int cnt = 0;
        int prev = 0;
        for(int i=0; i<list.size(); i++) {
            Node cur = list.get(i);
            if(cur.r>mid) return false;
            if(prev==0||prev+mid<=cur.c) {
                prev = cur.c;
                cnt++;
                if(cnt>num) return false;
            }
        }
        return true;
    }
}
