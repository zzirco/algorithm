import java.io.*;
import java.util.*;

public class test {
    static final int[] di = {-1,1,0,0};
    static final int[] dj = {0,0,-1,1};
    static int n, m, cnt;;
    static int[][] map;
    static boolean[][] v;
    static ArrayList<int[]> list = new ArrayList<>();
    static void dfs(int i, int j, int idx) {
        if(i==list.get(idx)[0]&&j==list.get(idx)[1]) {
            if(idx==m-1) {
                cnt++;
                return;
            }
            dfs(i,j,idx+1);
        }
        for(int d=0; d<4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(ni>=0&&ni<n&&nj>=0&&nj<n&&!v[ni][nj]&&map[ni][nj]!=1) {
                v[i][j] = true;
                dfs(ni, nj, idx);
                v[i][j] = false;
            }
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        v = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{r,c});
        }
        int starti = list.get(0)[0]-1;
        int startj = list.get(0)[1]-1;
        dfs(starti, startj, 0);
        System.out.println(cnt);
    }
}
