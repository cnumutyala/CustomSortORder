/*
 * Copyright 2012 by Srinivasrao(cnu.mutyala@gmail.com), Inc. All rights reserved.
 *
 * This software may only be used in connection with an executed license
 * agreement with Srinivas rao. This software may not be copied, published,
 * distributed, modified, sublicensed, sold or shared with any third party
 * without the express written consent of cnu.mutyala@gmail.com.
 */
package com.custom.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author smutyala
 * 
 * This SortOrderComparator doing the sort order of input list of objects.
 * Generic sort order of object
 * Required details
 *    Add required annotations of list getter/setter method
 *    EX(@Sort(sortType=SortTypes.DESC,fieldName=<<Object field name>>))
 *    
 *    Call SortOrderComparator().sort(param1,param2);
 *    EX(SortOrderComparator().sort(<<CurrentClass>>.classs,List))
 *
 */
public class SortOrderComparator {
	
	protected static final Logger log = LoggerFactory.getLogger(SortOrderComparator.class);
	
	private final static String METHOD_PREFIX="get";
	
	private static String methodName;
	
	private static SortTypes type;
	
	/**
	 * return the list of objects with sort order.
	 * @param clazz
	 * @param sortList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static void sort(final Class<?> clazz,List<? extends Object> sortList) {
		List<Object> sortOrderList=new ArrayList<Object>();
		Class inputCalss=void.class;
		if(sortList!=null && sortList.size()>0){
			inputCalss=sortList.get(0).getClass();
		}
		sortOrderList=(List<Object>) sortList;
		getAnnotation(clazz,inputCalss.getName());
		Collections.sort(sortOrderList,new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				return compareObject(o1,o2);
			}
		});
		sortList=sortOrderList;
	}
	
	/**
	 * get annotation of input list
	 * 
	 * @param clazz
	 */
	private static void getAnnotation(final Class<?> clazz,final String inputClass){
		try {
			 Method[] methods = clazz.getMethods();
			 for (Method method : methods) {
				 Annotation[] annotations= method.getAnnotations();
				 if(annotations!=null && annotations.length>0){
					
					 for (Annotation annotation : annotations) {
						 if (annotation instanceof Sort) {
							 Sort sort=(Sort) annotation;
							 if(sort.sortCalss().getName().equals(inputClass)){
								 methodName=sort.fieldName();
								 type=sort.sortType();
								 methodName=METHOD_PREFIX+methodName.substring(0,1).toUpperCase()+methodName.substring(1); 
							 }
						 }						 	
					 }
				 }				 
			}
			 
		} catch (Exception e) {
			log.error("Sort order annotation configuration wrong"+e.getMessage());
		}
	}
	/**
	 * compare objects
	 * @param sortOne
	 * @param sortTwo
	 * @return
	 */
	private static int compareObject(final Object sortOne, final Object sortTwo) {
		try {
			Method sortMethod1=sortOne.getClass().getMethod(methodName, null);
			Method sortMethod2=sortTwo.getClass().getMethod(methodName, null);
			Object bigValue=(Object) sortMethod1.invoke(sortOne, null);
			Object smallValue=(Object) sortMethod2.invoke(sortTwo, null);
			 if (bigValue instanceof Comparable && smallValue instanceof Comparable) {
				 if(type.equals(SortTypes.ASC)){
					 return bigValue.toString().compareTo(smallValue.toString());
				 }else{
					 return smallValue.toString().compareTo(bigValue.toString());
				 }
			 }
		} catch (Exception e) {
			log.error("Sort order method invocation failure"+e.getMessage());
		} 
		return 0;
	}

}
