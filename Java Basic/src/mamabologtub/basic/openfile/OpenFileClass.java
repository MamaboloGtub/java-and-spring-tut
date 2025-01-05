package mamabologtub.basic.openfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenFileClass {
	public void testRun() {
		System.out.println("testing");
		try {
			List<Row> records =  new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/TshepoMahudu/GitHub/coursera/Java Basic/src/mamabologtub/basic/openfile/country_vaccinations.csv"));
			
			String line;
			line = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");
				records.add(new Row(Arrays.asList(values)));
			}
			//top 15 on the records
			records.stream().limit(15).forEach(System.out::println);
			
			//last ten on the records
			records.stream().skip(records.stream().count() - 10).forEach(System.out::println);
			
			// count countries use a distinct method
			records.stream().map(x -> x.country).distinct().forEach(System.out::println);
			
			//count rows and nulls
			System.out.println("COunt: "+ records.stream().count());
			System.out.println("Count of nulls: "+ records.stream().filter(x -> x.daily_vaccinations.equals("")).count());
			
			//summary of daily vaccinations in a certain country
			System.out.println("Total: " + records.stream()
			  .filter(x -> x.country.equals("Nigeria"))
			  .filter(x -> !x.daily_vaccinations.equals(""))
			  .map(x -> x.daily_vaccinations)
			  .mapToDouble(Double::parseDouble)
			  .sum());
			
			//total vaccinations per country
			records.stream().map(y -> y.country).distinct().forEach(y -> {
				System.out.println("Total vaccinations in : "+ y + " = " + records.stream()
				  .filter(x -> x.country.equals(y))
				  .filter(x -> !x.daily_vaccinations.equals(""))
				  .map(x -> x.daily_vaccinations)
				  .mapToDouble(Double::parseDouble)
				  .sum());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

//class Row {
//	String daily_vaccinations;
//	String country;
//	
//	public Row(List list) {
//		this.daily_vaccinations = (String)(list.get(7));
//		this.country = (String)(list.get(0));
//	}
//	public String toString() {
//	 return country+ ", " +daily_vaccinations;		
//	}
//
//}
