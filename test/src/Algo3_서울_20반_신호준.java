import java.io.*;
import java.util.*;

public class Algo3_서울_20반_신호준 {
	static int R, C;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static char[][] arr;
	static boolean[][] v;
	static boolean Done = false;
	// 빙하가 녹는 부분을 탐색하는 bfs
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v[ni][nj]) {
					if(arr[ni][nj]=='X') {
						v[ni][nj] = true;
						continue;
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	// L끼리 만나는지 탐색하기 위한 bfs
	static boolean bfs2(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v[ni][nj]&&arr[ni][nj]!='X') {
					if(arr[ni][nj]=='L') return true;
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		v = new boolean[R][C];
		// 입력받기
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// L 위치 추출
		int x = 0, y = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]=='L') {
					x = i;
					y = j;
					break;
				}
			}
		}
		// L끼리 만나지 않는다면 계속 반복
		int cnt = 0;
		while(!bfs2(x,y)) {
			v = new boolean[R][C];
			// 빙하 녹는 부분 탐색
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(!v[i][j]&&arr[i][j]=='.') {
						bfs(i,j);
					}
				}
			}
			// 탐색한 빙하의 녹는 부분을 녹이기
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(v[i][j]) {
						if(arr[i][j]=='L') continue;
						arr[i][j] = '.';
					}
				}
			}
			// 날짜 증가
			cnt++;
			// 방문배열 초기화
			v = new boolean[R][C];
		}
		System.out.println(cnt);
	}
}
