package mamabologtub.basic;

import java.util.stream.Stream;

public class StreamOfStrings {
	
	public void ofStrings() {
		//string operations on a stream
		Stream.of("tshepo", "mama", "bolo")
		  .map(s -> s.toUpperCase())
		  .forEach(System.out::println);
		
		Stream.of("key_123", "key_246", "key_369")
		  .map(s -> s.split("_"))
		  .map(s -> s[1])
		  .forEach(System.out::println);
		
		Stream.of("key_123", "key_246", "key_369")
		  .map(s -> s.split("_"))
		  .map(s -> s[1]).mapToInt(Integer::parseInt)
		  .forEach(System.out::println);
				
				
	}

}
