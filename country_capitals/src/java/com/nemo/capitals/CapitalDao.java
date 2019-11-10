package java.com.nemo.capitals;

import java.util.List;

public interface CapitalDao {
		
	List<CountryCapitalBean> getCountriesCapitalsList();
	String getCapitalByCountry(String country);
	void addCountryCapital(CountryCapitalBean ccb);
}
