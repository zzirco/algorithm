package a0220.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_5653_줄기세포배양_서울_20반_신호준 {
	static int N, M, K, ni, nj;
    static int[][] map;
    static boolean[][] v;
    static Queue<Cell> queue = new ArrayDeque<>();
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static final short DEATH = 0, ACTIVE = 1, INACTIVE = 2;

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_5653.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N+K+2][M+K+2];
            v = new boolean[N+K+2][M+K+2];
            queue.clear();

            int temp;
            for (int i=K/2+1; i<N+K/2+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K/2+1; j<M+K/2+1; j++) {
                    temp = Integer.parseInt(st.nextToken());
                    if (temp != 0) {
                        map[i][j] = temp;
                        v[i][j] = true;
                        queue.add(new Cell(i, j, temp));
                    }
                }
            }
            int answer = solution();
            System.out.println("#"+tc+" "+answer);
        }
    }

    private static int solution() {
        int count = K;
        Cell cell;
        while (count-->0) {
            int len = queue.size();
            for (Cell c : queue) {
                if (c.status==ACTIVE) check(c); // 주변에 세포 value 정해줌
            }

            for (int t=0; t<len; t++) {
                cell = queue.poll();
                if (cell.status==ACTIVE) { // 활성화 상태인 경우만 번식
                    for (int d=0; d<4; d++) { // 상하좌우
                        ni = cell.i + di[d];
                        nj = cell.j + dj[d];

                        if (v[ni][nj]) continue;

                        queue.add(new Cell(ni, nj, map[ni][nj])); // 번식된 세포 추가
                        v[ni][nj] = true; // 방문 처리
                    }
                }

                cell.next(); // 세포 상태 변화
                
                if (cell.status == DEATH) continue; // 죽은 세포는 queue에서 제외
                queue.add(cell);
            }
        }
        return queue.size();
    }

    private static void check(Cell cell) {
        for (int i=0; i<4; i++) {
            ni = cell.i + di[i];
            nj = cell.j + dj[i];

            if (v[ni][nj]) continue;
            if (map[ni][nj]<cell.value) map[ni][nj] = cell.value;
        }
    }

    static class Cell {
        int i, j;
        int value, temp;
        short status;

        public Cell(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
            this.temp = value;
            this.status = INACTIVE;
        }
        public void next() {
            switch (status) {
                case INACTIVE: // 비활성화 상태
                    if (--temp==0) status = ACTIVE;
                    break;
                case ACTIVE: // 활성화 상태
                    if (++temp==value) status = DEATH;
                    break;
            }
        }
    }
}
