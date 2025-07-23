package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2448 {
    static int N;
    static char[][] map;
    static void recursion(int i, int j, int W) {
        if(W==3) {
            for(int r=0; r<3; r++) {
                for(int c=0; c<3; c++) {
                    map[i+r][j+c] = (r==1&&c==1)?' ':'*';
                }
            }
            return;
        }
        for(int r=0; r<W; r+=W/3) {
            for(int c=0; c<W; c+=W/3) {
                if(r!=W/3||c!=W/3) {
                    recursion(i+r,j+c,W/3);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                map[r][c] = ' ';
            }
        }
        recursion(0,0,N);
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
