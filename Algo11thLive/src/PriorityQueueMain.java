import java.io.*;
import java.util.*;

public class PriorityQueueMain {
	static class Car implements Comparable<Car> {
		String name; int year;
		Car(String name, int year){
			setName(name);
			setYear(year);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		@Override
		public String toString() {
			return getName()+getYear();
		}
		@Override
		public int compareTo(Car o) {
			return name.compareTo(o.name);
		}
	}
	public static void main(String[] args) {
		///*
		//PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.reverseOrder());
//		PriorityQueue<Car> pq = new PriorityQueue<>(new Comparator<Car>() {
//			@Override
//			public int compare(Car o1, Car o2) {
//				return Integer.compare(o1.year, o2.year);
//			}
//		});
		PriorityQueue<Car> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.year, o2.year));
		//PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.comparing(t->t.year, Comparator.reverseOrder()));
		//PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.comparing(Car::getYear).reversed());
		pq.offer(new Car("아반떼",2015));
		pq.offer(new Car("그랜저",2007));
		pq.offer(new Car("소나타",2024));
		pq.offer(new Car("아반떼",2015));
		pq.offer(new Car("그랜저",2007));
		pq.offer(new Car("소나타",2024));
		System.out.println(pq);
		System.out.println();
		while(!pq.isEmpty()) System.out.println(pq.poll());
		System.out.println();
		//*/
		/*
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		System.out.println(pq);
		System.out.println();
		while(!pq.isEmpty()) System.out.println(pq.poll());
		System.out.println();
		*/
	}
}
