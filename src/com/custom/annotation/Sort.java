/*
 * Copyright 2012 by Srinivasrao(cnu.mutyala@gmail.com), Inc. All rights reserved.
 *
 * This software may only be used in connection with an executed license
 * agreement with Srinivas rao. This software may not be copied, published,
 * distributed, modified, sublicensed, sold or shared with any third party
 * without the express written consent of cnu.mutyala@gmail.com.
 */
package com.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Sort {
	
	SortTypes sortType() default SortTypes.ASC;
	Class sortCalss() default void.class;
	String fieldName() default "id";
	
	
}
