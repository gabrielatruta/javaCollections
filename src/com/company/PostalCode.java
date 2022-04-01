package com.company;


public class PostalCode {
	
	private Integer Number;
	private String Address;
	
	public PostalCode(Integer number, String address) {
		Number = number;
		Address = address;
	}
	
	public Integer getNumber() {
		return Number;
	}
	
	public void setNumber(Integer number) {
		Number = number;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PostalCode)) return false;
		PostalCode postalCode = (PostalCode) o;
		return Number.equals(postalCode.getNumber()) && Address.equals(postalCode.getAddress());
	}
	
}
