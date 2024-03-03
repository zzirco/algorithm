package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_17143_낚시왕 {
	static int R, C;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,1,-1};
	static int[][] map;
	static ArrayList<Shark> shark;
	static int ans;
	static void solution() {
		for(int j=0; j<C; j++) {
			fishing(j);
			move();
			eat();
		}
	}
	static void fishing(int j) {
		int close = Integer.MAX_VALUE;
		for(Shark s:shark) {
			if(s.c==j) {
				close = Math.min(close, s.r);
			}
		}
		for(Shark s:shark) {
			if(s.r==close&&s.c==j) {
				ans += s.z;
				shark.remove(s);
				break;
			}
		}
	}
	static void move() {
		// 상어 이동을 시작한다
		for(Shark s:shark) {
			int r = s.r;
			int c = s.c;
			int speed = s.s;
			int d = s.d;
			// 상어 이동
			for(int cnt=0; cnt<speed; cnt++) {
				int nr = r + di[d];
				int nc = c + dj[d];
				if(nr>=0&&nr<R&&nc>=0&&nc<C) {
					r = nr;
					c = nc;
				} else {
					if(d==0) d = 1;
					else if(d==1) d = 0;
					else if(d==2) d = 3;
					else if(d==3) d = 2;
					cnt--;
				}
			}
			// 상어 이동이 끝나면 정보 갱신
			s.r = r;
			s.c = c;
			s.d = d;
			// 이동 후 위치 1로 초기화
			//map[r][c] = 1;
		}
	}
	static void eat() {
		// 만약 이동이 끝난 위치에 다른 상어가 있다면
		int size = shark.size();
		for(int k=0; k<size; k++) {
			Shark s = shark.get(k);
			for(int i=0; i<size; i++) {
				Shark cmp = shark.get(i);
				if(s.r==cmp.r&&s.c==cmp.c&&s.z!=cmp.z) { // 자신을 제외하고 크기 비교 후 작은 상어 리스트에서 삭제
					if(s.z>cmp.z) {
						shark.remove(cmp);
						size--;
						i--;
					} else {
						shark.remove(s);
						size--;
						i--;
					}
				}
			}
		}
	}
	static class Shark {
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		shark = new ArrayList<>();
		ans = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			shark.add(new Shark(r,c,s,d,z));
			map[r][c] = 1;
		}
		solution();
		System.out.println(ans);
		br.close();
	}
}
