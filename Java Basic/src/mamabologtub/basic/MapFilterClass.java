package mamabologtub.basic;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapFilterClass {
	
	public void mapFilter() {
		
		// map()
		Stream.of(4, 5, 6, 7)
		  .map(x -> x*x)
		  .map(x -> x-5)
		  .forEach(System.out::println);
		
		//Filter()
		Stream.of(10, 20, 30, 40, 50, 60, 70)
		  .filter(x -> x > 20).map(x -> x / 10).forEach(System.out::println);
		
		// Streams can't be reused. A terminal operation closes the sream
		IntStream intStream = IntStream.of(2, 5, 7, -1, -5);
		IntStream st = IntStream.of(2, 5, 7, -1, -5);
		System.out.println("sum = " + intStream.sum());
		System.out.println("Count = " + st.count());
		
		System.out.println("Sum using reduce() = " + Stream.of(1, 2, 3, 4)
		  .reduce(0, (a, b) -> a + b));
		System.out.println("product using reduce() = " + Stream.of(1, 2, 3, 4)
		  .reduce(1, (a, b) -> a * b));
	}

}
