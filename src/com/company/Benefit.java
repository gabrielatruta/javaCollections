package com.company;

import java.util.Objects;

public class Benefit {
	
	private String name;
	private Integer price;
	private Person owner;
	private Department department;
	
	public Benefit(String name, Integer price, Person owner, Department department) {
		this.name = name;
		this.price = price;
		this.owner = owner;
		this.department = department;
	}
	
	public String getOwnerName() {
		return owner.getName();
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Benefits{" +
				"name='" + name + '\'' +
				", price=" + price + '\'' +
				", owner=" + owner.getName() + '\'' +
				", department=" + department.getName() +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Benefit)) return false;
		Benefit benef = (Benefit) o;
		return name.equals(benef.getName()) && price.equals(benef.getPrice()) && owner.equals(benef.getOwner())
				&& department.equals(benef.getDepartment());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, owner);
	}
}
