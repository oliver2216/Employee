package com.sagar.Beans;

public class Country {

	@Override
	public String toString() {
		return "Country [city=" + city + ", countryNmae=" + countryNmae + "]";
	}
	
	private City city;
	private String countryNmae;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getCountryNmae() {
		return countryNmae;
	}
	public void setCountryNmae(String countryNmae) {
		this.countryNmae = countryNmae;
	}
	
	
}
