package 모의역량테스트;

import java.io.*;
import java.util.*;
 
public class Solution_D9_5658_보물상자비밀번호_서울_20반_신호준 {
	static int N, K;
	static Queue<Character> q;
	static TreeSet<Integer> num;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_5658.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	q = new ArrayDeque<>();
        	char[] ca = br.readLine().toCharArray();
        	for(int i=0; i<N; i++) {
        		q.offer(ca[i]);
        	}
        	num = new TreeSet<>();
        	for(int k=0; k<N/4; k++) {
        		for(int i=0; i<4; i++) {
        			String s = "0x";
        			for(int j=0; j<N/4; j++) {
        				char c = q.poll();
        				q.offer(c);
        				s += c;
        			}
        			num.add(Integer.decode(s));
        		}
        		char cur = q.poll();
        		q.offer(cur);
        	}
        	for(int i=0; i<K-1; i++) {
        		num.pollLast();
        	}
        	sb.append("#"+tc+" "+num.pollLast()+"\n");
        }
        System.out.println(sb);
    }
}
