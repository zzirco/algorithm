package a0202.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_1218_괄호짝짓기_서울_20반_신호준 {
	static int ans = 1;
	static Stack<String> stack = new Stack<>();
	static boolean isOk(String s) {
		if(stack.peek().equals(s)) {
			stack.pop();
			return true;
		}
		ans = 0;
		return false;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			String[] sa = s.split("");
			ans = 1;
			
			for(int i=0; i<N; i++) {
				if(sa[i].equals("(")||sa[i].equals("{")||sa[i].equals("[")||sa[i].equals("<")) {
					stack.push(sa[i]);
				} else {
					if(sa[i].equals(")")) {
						if(!isOk("(")) break;
					} else if(sa[i].equals("}")) {
						if(!isOk("{")) break;
					} else if(sa[i].equals("]")) {
						if(!isOk("[")) break;
					} else if(sa[i].equals(">")) {
						if(!isOk("<")) break;
					}
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
