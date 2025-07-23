package softeer;

import java.io.*;
import java.util.*;

public class 함께하는효도{
    static final int[] di = {-1,1,0,0};
    static final int[] dj = {0,0,-1,1};
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int sum;
    static int i1,j1,i2,j2;
    
    private static List<Integer> list = new ArrayList<>();
    
    public static void dfs(int i, int j, int cnt) {
        if(cnt==3) {
        	if(!v[i2][j2]) sum += map[i2][j2];
        	v[i2][j2] = true;
            dfs2(i2,j2,0);
            return;
        }
        for(int d=0; d<4; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0&&ni<N&&nj>=0&&nj<N) {
            	boolean add = false;
            	if(!v[ni][nj]) {
            		sum += map[ni][nj];
            		add = true;
            	}
                v[ni][nj] = true;
                dfs(ni,nj,cnt+1);
                v[ni][nj] = false;
                if(add) {
                	sum -=  map[ni][nj];
                	add = false;
                }
            }
        }
    }
    public static void dfs2(int i, int j, int cnt) {
        if(cnt==3) {
        	list.add(sum);
            return;
        }
        for(int d=0; d<4; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0&&ni<N&&nj>=0&&nj<N) {
            	boolean add = false;
            	if(!v[ni][nj]) {
            		sum += map[ni][nj];
            		add = true;
            	}
                v[ni][nj] = true;
                dfs2(ni,nj,cnt+1);
                v[ni][nj] = false;
                if(add) {
                	sum -=  map[ni][nj];
                	add = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        sum = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        i1 = Integer.parseInt(st.nextToken());
        j1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        i2 = Integer.parseInt(st.nextToken());
        j2 = Integer.parseInt(st.nextToken());
        v[i1][j1] = true;
        sum += map[i1][j1];
        dfs(i1,j1,0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
}