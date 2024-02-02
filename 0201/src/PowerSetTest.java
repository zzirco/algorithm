
// N개의 원소를 입력받아 가능한 모든 부분집합 생성
// 1<=N<=10
import java.util.*;

public class PowerSetTest {
	
	static int N, input[];
	static boolean isSelected[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0);
		sc.close();
	}
	private static void generateSubset(int cnt) {
		
		if(cnt==N) { // 모든 원소가 고려되었다면
			for(int i=0; i<N; i++) {
				System.out.print((isSelected[i]?input[i]:"X")+"\t");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true; // 부분집합에 포함
		generateSubset(cnt+1);
		isSelected[cnt] = false; // 부분집합에 비포함
		generateSubset(cnt+1);
	}
}
