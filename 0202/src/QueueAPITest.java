import java.util.ArrayDeque;
import java.util.Queue;

public class QueueAPITest {

	public static void main(String[] args) {
		Queue<String> queue = new ArrayDeque<String>();
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("대전 : 갓병찬");
		queue.offer("서울 : 자바의신전은수");
		queue.offer("서울 : 김동근");
		queue.offer("서울 : 닥터홍");
		queue.offer("서울 : The Java 조용준");
		queue.offer("광주 : 제기차기 선수 임경혜");
		queue.offer("부울경 : 축신 정상훈");
		queue.offer("서울 : 그녀는 예뻤다 이은진");
		queue.offer("구미 : 김재웅김계희");
		queue.offer("대전 : 양유진");
		
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println("======================================");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
