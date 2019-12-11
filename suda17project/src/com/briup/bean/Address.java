package com.briup.bean;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String contury;
	private String city;
	private String street;
	public Address(String contury, String city, String street) {
		super();
		this.contury = contury;
		this.city = city;
		this.street = street;
	}
	public String getContury() {
		return contury;
	}
	public void setContury(String contury) {
		this.contury = contury;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [contury=" + contury + ", city=" + city + ", street=" + street + "]";
	}
	
	
	
}
