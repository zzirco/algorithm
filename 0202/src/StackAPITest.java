import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		System.out.println(stack.isEmpty()+"//"+stack.size());
		stack.push("대전 : 갓병찬");
		stack.push("서울 : 자바의신전은수");
		stack.push("서울 : 김동근");
		stack.push("서울 : 닥터홍");
		stack.push("서울 : The Java 조용준");
		stack.push("광주 : 제기차기 선수 임경혜");
		stack.push("부울경 : 축신 정상훈");
		stack.push("서울 : 그녀는 예뻤다 이은진");
		System.out.println(stack.isEmpty()+"//"+stack.size());
		stack.push("구미 : 김재웅김계희");
		stack.push("대전 : 양유진");
		
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty()+"//"+stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty()+"//"+stack.size());
		System.out.println("======================================");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
