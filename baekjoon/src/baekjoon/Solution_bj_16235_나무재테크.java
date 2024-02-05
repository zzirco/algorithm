package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16235_나무재테크 {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	static class Tree { // 나무 정보를 저장할 클래스
		int x, y, z; // x,y는 나무의 위치, z는 나무의 나이
		boolean alive; // 나무의 생존 여부를 확인할 변수
		Tree(int x, int y, int z, boolean alive) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.alive = alive;
		}
		@Override
		public String toString() { // 디버깅을 위한 toString 메소드 재정의
			return x+" "+y+" "+z+" "+alive;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][N]; // 현재 땅의 양분 상태를 나타낼 2차원 배열
		int[][] energy = new int[N][N]; // 매 해 겨울에 추가될 양분을 저장할 2차원 배열
		LinkedList<Tree> trees = new LinkedList<>(); // 나무들의 정보를 저장할 LinkedList
		
		for(int i=0; i<N; i++) { // 초기에 땅의 양분을 모두 5로 초기화
			for(int j=0; j<N; j++) {
				field[i][j] = 5;
			}
		}
		for(int i=0; i<N; i++) { // 추가 양분 배열 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) { // 나무 개수만큼 나무 정보 입력받아 LinkedList에 저장
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x,y,z,true));
		}
		int cnt=0;
		while(cnt!=K) { // 주어진 해가 지날 때까지 반복
			// Collections.sort(tree, Comparator.comparing(Pair::getZ));
			// 봄 : 양분 먹고 나이 1 증가
			// iterator를 사용하면 동작시간이 빠르고, 요소 제거에 따른 ConcurrentModificationException 발생 해결 가능
			for(Iterator<Tree> it = trees.iterator(); it.hasNext();) {
				Tree current = it.next();
				int x = current.x;
				int y = current.y;
				int z = current.z;
				if(field[x][y]>=z) { // 현재 땅의 양분이 나무의 나이보다 많거나 같으면
					field[x][y]-=z; // 현재 땅의 양분을 나무의 나이만큼 감소시키고
					current.z=++z; // 나무의 나이를 1살 증가시킨다
				} else { // 현재 땅의 양분이 나무의 나이보다 적으면
					current.alive = false; // 나무의 생존여부를 변경한다
				}
			}
			// 여름 : 죽은 나무 나이/2 양분 증가
			for(Iterator<Tree> it = trees.iterator(); it.hasNext();) {
				Tree current = it.next();
				if(current.alive==false) { // 나무의 생존 변수가 false이면
					field[current.x][current.y] += current.z/2; // 현재 땅의 양분을 나무의 나이를 2로 나눈만큼(소수점이하는 버린다) 증가시킨다 
					it.remove(); // 나무 배열 trees에서 죽은 나무의 정보를 제거한다
				}
			}
			// 가을 : 나무 나이 5의 배수일 때 나무 주변 팔방으로 나이 1 나무 생성
			// 시간초과 원인 : for 보다 for-each가 훨씬 빠르다
			LinkedList<Tree> temp = new LinkedList<>(); // 추가될 나무를 저장할 임시 LinkedList를 선언
			for(Tree tree:trees) {
				if(tree.z%5==0) { // 나무의 나이가 5의 배수이면
					for(int d=0; d<8; d++) { // 나무 주변을 팔방탐색하여
						int nx = tree.x + dx[d];
						int ny = tree.y + dy[d];
						if(nx>=0&&nx<N&&ny>=0&&ny<N) { // 인덱스를 벗어나지 않으면
							temp.add(new Tree(nx,ny,1,true)); // 1살 짜리 나무를 추가한다
						}
					}
				}
			}
			trees.addAll(0,temp); // 임시 리스트를 정규 리스트에 추가한다
			// 겨울 : 양분 추가
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					field[i][j] += energy[i][j]; // 입력받은 양분 배열만큼 현재 땅에 추가한다
				}
			}
			cnt++; // 햇수를 증가시킨다
		}
		//System.out.println(Arrays.deepToString(field));
		//System.out.println(tree);
		System.out.println(trees.size());
	}
}
/* 최대 시간 예제
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