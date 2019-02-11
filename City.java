package com.sagar.Beans;

public class City {
	
	
	
	private String cityName;
	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public String getCityName() {
		return cityName;
	}

}
