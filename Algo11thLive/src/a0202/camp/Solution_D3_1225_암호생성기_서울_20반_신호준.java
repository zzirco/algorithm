package a0202.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_1225_암호생성기_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int cnt = 1;
			while(queue.peek()!=0) {
				if(cnt==6) cnt = 1;
				int num = queue.poll()-cnt;
				if(num<=0) {
					num=0;
					queue.offer(num);
					break;
				}
				queue.offer(num);
				cnt++;
			}
			sb.append("#"+N+" ");
			for(int i=0; i<8; i++) {
				sb.append(queue.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
