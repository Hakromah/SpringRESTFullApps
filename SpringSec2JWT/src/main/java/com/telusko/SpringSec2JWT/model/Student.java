package com.telusko.SpringSec2JWT.model;

public class Student 
{
	private Integer id;
	
	private String name;
	
	private String course;

	public Student(Integer id, String name, String course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	

}
