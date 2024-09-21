package com.telusko.SpringBootRedisCache.model;

import java.io.Serializable;

public class Country implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer no;
	
	private String name;
	
	private String countryCode;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Country [no=" + no + ", name=" + name + ", countryCode=" + countryCode + "]";
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(Integer no, String name, String countryCode) {
		super();
		this.no = no;
		this.name = name;
		this.countryCode = countryCode;
	}
	
	

}
