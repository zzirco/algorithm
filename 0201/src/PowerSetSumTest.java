
// N개의 원소를 입력받아 가능한 모든 부분집합 생성
// 1<=N<=10
import java.util.*;

public class PowerSetSumTest {
	
	static int N, input[], target;
	static boolean isSelected[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt(); // 목표합
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0,0);
		sc.close();
	}
	private static void generateSubset(int cnt, int sum) { // sum : 기존 부분집합의 구성요소들의 합
		
		if(cnt==N) { // 모든 원소가 고려되었다면 부분집합을 구성하는 원소들의 합이 목표합이 되는지 체크
			if(sum == target) {
				for(int i=0; i<N; i++) {
					if(isSelected[i]) System.out.print(input[i]+"\t");
				}
				System.out.println();
			}
			return;
		}
		
		isSelected[cnt] = true; // 부분집합에 포함
		// sum += input[cnt] 이런 식으로 하면 안됨. 기존 상태를 그대로 가지고 있어야 함.
		generateSubset(cnt+1, sum+input[cnt]);
		isSelected[cnt] = false; // 부분집합에 비포함
		generateSubset(cnt+1, sum);
	}
}
