package mamabologtub.basic;

import java.util.Arrays;
import java.util.List;

public class StreamMethodsApi {
	
	public void methodApi() {
		List<Integer> integers = Arrays.asList(3, 6, 9, 12, 15);
		
		//use sum() mapToInt() all stats
		System.out.println("Sum: " + integers.stream()
		  .mapToInt(Integer::intValue).sum());
		System.out.println("Count: " + integers.stream()
		  .mapToInt(Integer::intValue).count());
		System.out.println("Average: " + integers.stream()
		  .mapToDouble(Integer::intValue).average());
		System.out.println("Max: " + integers.stream()
		  .mapToInt(Integer::intValue).max());
		System.out.println("min: " + integers.stream()
		  .mapToInt(Integer::intValue).min());
		System.out.println("Statistics: " +integers.stream()
				.mapToInt(Integer::intValue).summaryStatistics());
		
	}

}
