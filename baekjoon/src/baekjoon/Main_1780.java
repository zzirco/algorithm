package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1780 {
    static int N;
    static int[][] map;
    static int[] cnt = new int[3];
    static void recursion(int i, int j, int W) {
        if(W==1) {
            cnt[map[i][j]+1]++;
            return;
        }
        int cur = map[i][j];
        for(int r=0; r<W; r++) {
            for(int c=0; c<W; c++) {
                if(map[i+r][j+c]!=cur) {
                    recursion(i,j,W/3);
                    recursion(i,j+W/3,W/3);
                    recursion(i,j+2*W/3,W/3);
                    recursion(i+W/3,j,W/3);
                    recursion(i+W/3,j+W/3,W/3);
                    recursion(i+W/3,j+2*W/3,W/3);
                    recursion(i+2*W/3,j,W/3);
                    recursion(i+2*W/3,j+W/3,W/3);
                    recursion(i+2*W/3,j+2*W/3,W/3);
                    return;
                }
                cur = map[i+r][j+c];
            }
        }
        cnt[map[i][j]+1]++;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0,0,N);
        for(int num:cnt) {
            System.out.println(num);
        }
    }
}
