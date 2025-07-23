package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_bj_17143_낚시왕 {
	static int R, C;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,1,-1};
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
			if(d==0||d==1) {
				speed %= (R-1)*2;
			} else {
				speed %= (C-1)*2;
			}
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
			s.index = r*C+c;
		}
	}
	static void eat() {
		Collections.sort(shark);
		for(int i=shark.size()-1; i>0; i--) {
			Shark cur = shark.get(i);
			Shark prev = shark.get(i-1);
			if(cur.index==prev.index) {
				shark.remove(cur);
			}
		}
	}
	static class Shark implements Comparable<Shark> {
		int r, c, s, d, z, index;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.index = r*C+c;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + ", index=" + index + "]";
		}
		@Override
		public int compareTo(Shark o) {
			return (this.index==o.index)?Integer.compare(o.z, this.z):Integer.compare(this.index, o.index);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
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
		}
		solution();
		System.out.println(ans);
		br.close();
	}
}
