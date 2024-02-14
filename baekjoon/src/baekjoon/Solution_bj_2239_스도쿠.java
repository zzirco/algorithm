package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2239_스도쿠 {
	static int[][] arr;
	static void sudoku(int r, int c) {
		if(c==9) {
			sudoku(r+1,0);
			return;
		}
		if(r==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(arr[r][c]==0) {
			for(int k=1; k<=9; k++) {
				arr[r][c]=k;
				if(possible(r,c)) {
					sudoku(r,c+1);
				}
			}
			arr[r][c]=0;
			return;
		}
		sudoku(r,c+1);
	}
	static boolean possible(int r, int c) {
		for(int i=0; i<9; i++) {
			if(i==r) continue;
			if(arr[i][c]==arr[r][c]) return false;
		}
		for(int j=0; j<9; j++) {
			if(j==c) continue;
			if(arr[r][j]==arr[r][c]) return false;
		}
		int I = r/3;
		int J = c/3;
		for(int i=3*I; i<3*I+3; i++) {
			for(int j=3*J; j<3*J+3; j++) {
				if(i==r&&j==c) continue;
				if(arr[i][j]==arr[r][c]) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			String[] sa = s.split("");
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(sa[j]);
			}
		}
		sudoku(0,0);
	}
}
