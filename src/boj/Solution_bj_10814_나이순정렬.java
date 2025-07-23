package boj;

import java.io.*;
import java.util.*;

public class Solution_bj_10814_나이순정렬 {
	static class Member implements Comparable<Member> {
		int age;
		String name;
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Member o) {
			return Integer.compare(this.age, o.age);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(age, name));
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			Member m = list.get(i);
			int age = m.age;
			String name = m.name;
			sb.append(age+" "+name+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
