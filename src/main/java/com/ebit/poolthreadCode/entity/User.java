package com.ebit.poolthreadCode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private Long id;
	private String name;
	private int salary;
	private String teamname;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, int salary, String teamname) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.teamname = teamname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + ", teamname=" + teamname + "]";
	}

}
