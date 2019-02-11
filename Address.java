package com.sagar.Beans;

public class Address {

	@Override
	public String toString() {
		return "Address [address=" + address + ", country=" + country + "]";
	}
	private String address;
	private Country country;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	
}
