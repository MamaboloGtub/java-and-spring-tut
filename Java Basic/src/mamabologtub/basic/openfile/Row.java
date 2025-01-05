package mamabologtub.basic.openfile;

import java.util.List;

public class Row {
	String daily_vaccinations;
	String country;
	
	public Row(List list) {
		this.daily_vaccinations = (String)(list.get(7));
		this.country = (String)(list.get(0));
	}
	public String toString() {
	 return country+ ", " +daily_vaccinations;		
	}

}
