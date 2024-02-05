package a0205.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_1228_암호문1_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for(int i=0; i<C; i++) {
				String str = st.nextToken();
				StringTokenizer st2 = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				LinkedList<Integer> s =new LinkedList<>();
				for(int j=0; j<y; j++) {
					s.add(Integer.parseInt(st2.nextToken()));
				}
				list.addAll(x, s);
			}
			sb.append("#"+tc+" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
