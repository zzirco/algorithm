package a0206.camp;

import java.io.*;
import java.util.*;

class CompleteBinaryTree<T> {
	
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex; // 마지막으로 저장된 노드의 인덱스
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1]; // 0인덱스 사용하지 않음
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex==SIZE;
	}
	public void add(T e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	public int bfs() {
		if(isEmpty()) return -1;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기(노드 번호인덱스)
		
		while(!queue.isEmpty()) { // 방문할 대상이 있는 동안 반복
			int current = queue.poll();
			//System.out.println(nodes[current]); // 노드 처리
			
			//자신이 숫자일 경우
			if((char)nodes[current]!='+'&&(char)nodes[current]!='-'&&(char)nodes[current]!='*'&&(char)nodes[current]!='/') {
				if(current*2<=lastIndex) { // 자식이 존재하면 안된다
					return 0;
				}
			} else { // 자신이 연산자일 경우
				if(current*2+1>lastIndex) { // 자식이 무조건 존재해야 한다
					return 0;
				}
			}
			// 왼쪽 자식노드
			if(current*2<=lastIndex) queue.offer(current*2);
			// 오른쪽 자식노드
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
		return 1;
	}
	@Override
	public String toString() {
		return Arrays.toString(nodes);
	}
}
public class Solution_D4_1233_사칙연산유효성검사_서울_20반_신호준 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		A:for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			CompleteBinaryTree<Character> arr = new CompleteBinaryTree<>(N);
			int ans;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int v = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					int lc = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {
						int rc = Integer.parseInt(st.nextToken());
					} else {
						ans = 0;
						sb.append("#"+tc+" "+ans+"\n");
						for(int j=0; j<N-i-1; j++) {
							br.readLine();
						}
						continue A;
					}
				}
				arr.add(c);
			}
			ans = arr.bfs();
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
