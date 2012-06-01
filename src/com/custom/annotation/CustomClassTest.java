/*
 * Copyright 2012 by Srinivasrao(cnu.mutyala@gmail.com), Inc. All rights reserved.
 *
 * This software may only be used in connection with an executed license
 * agreement with Srinivas rao. This software may not be copied, published,
 * distributed, modified, sublicensed, sold or shared with any third party
 * without the express written consent of cnu.mutyala@gmail.com.
 */
package com.custom.annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author smutyala
 * 
 *Sort order Test Class
 */

public class CustomClassTest {
	
	List<Employee> employees=new ArrayList<Employee>();
	
	List<Student> students=new ArrayList<Student>();

	public void employeeSortOrder(){
		Employee e=new Employee(2,"test2",42000);
		Employee e1=new Employee(1,"test1",50000);
		Employee e2=new Employee(3,"test3",80000);
		employees.add(e);
		employees.add(e1);
		employees.add(e2);
		
		System.out.println("Employee BEFORE SORT ORDRE");
		for (Employee employee : employees) {
			System.out.println(employee.getId()+" "+ employee.getName()+" "+employee.getSalary());
		}
		System.out.println("Employee AFTER SORT ORDRE");
	
		SortOrderComparator.sort(employees,"name",SortTypes.DESC);
		
		for (Employee employee : employees) {
			System.out.println(employee.getId()+" "+ employee.getName()+" "+employee.getSalary());
		}
	}
	
	public void studentSortOrder(){
		Student s=new Student(2,"test2","5th");
		Student s1=new Student(1,"test1","1st");
		Student s2=new Student(3,"test3","7th");
		students.add(s);
		students.add(s1);
		students.add(s2);
		
		System.out.println("Student BEFORE SORT ORDRE");
		for (Student student : students) {
			System.out.println(student.getStudentId()+" "+ student.getStudentName()+" "+student.getStandard());
		}
		System.out.println("Student AFTER SORT ORDRE");
	
		SortOrderComparator.sort(this.getClass(),students);
		
		for (Student student : students) {
			System.out.println(student.getStudentId()+" "+ student.getStudentName()+" "+student.getStandard());
		}
	}
	
	
	public static void main(String args[]){
		CustomClassTest test=new CustomClassTest();
		test.employeeSortOrder();
		test.studentSortOrder();
	}
	
	@Sort(sortType=SortTypes.DESC,fieldName="salary",sortCalss=Employee.class)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Sort(sortType=SortTypes.ASC, fieldName="standard",sortCalss=Student.class)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
