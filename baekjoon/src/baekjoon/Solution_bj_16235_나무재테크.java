package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16235_나무재테크 {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	static class Pair {
		int x, y, z;
		boolean alive;
		Pair(int x, int y, int z, boolean alive) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.alive = alive;
		}
		
		public int getZ() {
			return z;
		}
		@Override
		public String toString() {
			return x+" "+y+" "+z+" "+alive;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][N];
		int[][] energy = new int[N][N];
		ArrayDeque<Pair> tree = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				field[i][j] = 5;
			}
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			tree.add(new Pair(x,y,z,true));
		}
		int cnt=0;
		while(cnt!=K) {
			//Collections.sort(tree, Comparator.comparing(Pair::getZ));
			//봄 : 양분 먹고 나이 1 증가
			int size = tree.size();
			for(Iterator<Pair> it = tree.iterator(); it.hasNext();) {
				Pair current = it.next();
				int x = current.x;
				int y = current.y;
				int z = current.z;
				if(field[x][y]>=z) {
					field[x][y]-=z;
					current.z=++z;
				} else {
					current.alive = false;
				}
			}
			//여름 : 죽은 나무 나이/2 양분 증가
			size = tree.size();
			for(Iterator<Pair> it = tree.iterator(); it.hasNext();) {
				Pair current = it.next();
				if(current.alive==false) {
					field[current.x][current.y] += current.z/2;
					it.remove();
				}
			}
			//가을 : 나무 나이 5의 배수일 때 나무 주변 팔방으로 나이 1 나무 생성
			size = tree.size();
			ArrayDeque<Pair> temp = new ArrayDeque<>();
			for(Iterator<Pair> it = tree.iterator(); it.hasNext();) {
				Pair current = it.next();
				if(current.z%5==0) {
					for(int d=0; d<8; d++) {
						int nx = current.x + dx[d];
						int ny = current.y + dy[d];
						if(nx>=0&&nx<N&&ny>=0&&ny<N) {
							temp.addFirst(new Pair(nx,ny,1,true));
						}
					}
				}
			}
			tree.addAll(temp);
			//겨울 : 양분 추가
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					field[i][j] += energy[i][j];
				}
			}
			cnt++;
		}
		//System.out.println(Arrays.deepToString(field));
		//System.out.println(tree);
		System.out.println(tree.size());
	}
}
/*
10 1 1000
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
1 1 1
*/