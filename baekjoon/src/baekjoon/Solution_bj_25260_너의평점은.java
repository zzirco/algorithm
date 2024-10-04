package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_25260_너의평점은 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double sum = 0;
		double totSum = 0;
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			double grade = Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			if(s.equals("P")) continue;
			double sGrade = 0;
			switch(s) {
				case "A+":
					sGrade = 4.5;
					break;
				case "A0":
					sGrade = 4.0;
					break;
				case "B+":
					sGrade = 3.5;
					break;
				case "B0":
					sGrade = 3.0;
					break;
				case "C+":
					sGrade = 2.5;
					break;
				case "C0":
					sGrade = 2.0;
					break;
				case "D+":
					sGrade = 1.5;
					break;
				case "D0":
					sGrade = 1.0;
					break;
				case "F":
					sGrade = 0.0;
					break;
			}
			sum += grade;
			totSum += grade * sGrade;
			st = new StringTokenizer(br.readLine(), " ");
		}
		if(totSum==0) {
			System.out.println(0.000000);
		} else {
			System.out.println(totSum/sum);
		}
	}
}
