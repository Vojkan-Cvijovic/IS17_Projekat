package com.tour.agency.model;

public class Reservation {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{ \"type\" : \"reservation\", \"id\" : " + id + ", \"name\" : " + name + " } \n";
	}
}
