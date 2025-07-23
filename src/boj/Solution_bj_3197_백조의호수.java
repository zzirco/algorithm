package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_3197_백조의호수 {
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Queue<Node> q;
	static Queue<Node> waterQ;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][] v;
	static Node[] swan;
	static int R, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		waterQ = new LinkedList<>();
		q = new LinkedList<>();
		swan = new Node[2];
		map = new char[R][C];
		v = new boolean[R][C];
		
		int cnt = 0;
		for(int r=0 ; r<R ; r++) {
			char[] line = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				map[r][c] = line[c];
				if(map[r][c]=='L') {
					swan[cnt++] = new Node(r, c);
				}
				if(map[r][c]!='X') {
					waterQ.offer(new Node(r, c));
				}
			}
		}
		
		q.offer(swan[0]);
		v[swan[0].r][swan[0].c] = true;
		int day = 0;
		boolean meet = false;
		
		while(true) {
			Queue<Node> nextQ = new LinkedList<>();
			while(!q.isEmpty()) {
				Node cur = q.poll();
				if(cur.r==swan[1].r&&cur.c==swan[1].c) {
					meet = true;
					break;
				}
				for(int d=0; d<4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&!v[nr][nc]) {
						v[nr][nc] = true;
						if(map[nr][nc]=='X') {
							nextQ.offer(new Node(nr, nc));
							continue;
						}
						q.offer(new Node(nr, nc));
					}
				}
			}
			if(meet) break;
			q = nextQ;
			int size = waterQ.size();
			for(int i=0; i<size; i++) {
				Node now = waterQ.poll();
				for(int d=0; d<4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[nr][nc]=='X') {
						map[nr][nc] = '.';
						waterQ.offer(new Node(nr, nc));
					}
				}
			}
			day++;
		}
		System.out.println(day);
	}
}
