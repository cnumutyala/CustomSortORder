/*
 * Copyright 2012 by Srinivasrao(cnu.mutyala@gmail.com), Inc. All rights reserved.
 *
 * This software may only be used in connection with an executed license
 * agreement with Srinivas rao. This software may not be copied, published,
 * distributed, modified, sublicensed, sold or shared with any third party
 * without the express written consent of cnu.mutyala@gmail.com.
 */
package com.custom.annotation;


public class Employee{
	private Integer id;
	private String name;
	private Integer salary;
	
	public Employee(Integer id,String name,Integer salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
		
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
