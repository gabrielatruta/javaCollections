package com.company;

import java.util.Objects;

public class Band {
	
	private String name;
	private String genre;
	private String country;
	private int numberOfMembers;
	
	public Band(String name, String genre, String country, int numberOfMembers) {
		this.name = name;
		this.genre = genre;
		this.country = country;
		this.numberOfMembers = numberOfMembers;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getNumberOfMembers() {
		return numberOfMembers;
	}
	
	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Band)) return false;
		Band bandObject = (Band) o;
		return numberOfMembers == bandObject.getNumberOfMembers() && name.equals(bandObject.getName())
				&& Objects.equals(genre, bandObject.getGenre())
				&& Objects.equals(country, bandObject.getCountry());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, genre, country, numberOfMembers);
	}
}
