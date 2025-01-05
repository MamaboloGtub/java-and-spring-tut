package mamabologtub.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiClass {
	
	public void testApi() {
		List<Integer> integers = Arrays.asList(2, 4, 5, 6, 7, 8, 9);
		System.out.println(integers);
		
		//convert to stream
		integers.stream().forEach(System.out::println);
		//longhand of the above
//		integers.stream().forEach(integer -> {
//			System.out.println(integer);
//		});
		
		
		//customize the stream
	   integers.stream().forEach(x -> {
		   System.out.println("Custom forEach: " + x*x);
	   });
	   
	   //use of()
	   Stream.of(3, 4, 5, 5,6).forEach(System.out::println);
	   
	   //use IntStream
	   IntStream.range(90, 100).forEach(System.out::println);
	   
	   //of() findFirst() ifPresent()
	   Stream.of(2, 3, 4).findFirst().ifPresent(System.out::println);
	   
	   //noneMAtch()
	   System.out.println(IntStream.range(90, 95).noneMatch(x -> x < 90));
	} 

}
