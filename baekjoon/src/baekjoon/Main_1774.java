package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1774 {
    static int N, M;
    static int[] p;
    static void make() {
        p = new int[N];
        for(int i=0; i<N; i++) p[i] = i;
    }
    static int find(int a) {
        if(a==-1) return -1;
        if(p[a]==a) return a;
        return p[a] = find(p[a]);
    }
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return false;
        if(a==-1) p[b] = a;
        else p[a] = b;
        return true;
    }
    public static class Node {
        int from, to;
        double weight;
        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] spot = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            spot[i][0] = x;
            spot[i][1] = y;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
        for(int i=0; i<N; i++) {
            int x1 = spot[i][0];
            int y1 = spot[i][1];
            for(int j=0; j<i; j++) {
                int x2 = spot[j][0];
                int y2 = spot[j][1];
                double weight = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
                pq.offer(new Node(i, j, weight));
            }
        }
        make();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            union(v1, v2);
        }
        double result = 0;
        while(!pq.isEmpty()) {
            Node edge = pq.poll();
            if(union(edge.from, edge.to)) {
                result += edge.weight;
            }
        }
        System.out.printf("%.2f", result);
        br.close();
    }
}
