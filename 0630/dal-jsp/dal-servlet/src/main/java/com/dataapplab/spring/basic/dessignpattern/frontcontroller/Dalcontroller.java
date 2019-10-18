package com.dataapplab.spring.basic.dessignpattern.frontcontroller;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * ElementType.TYPE (class, interface, enum)
 * ElementType.FIELD (instance variable)
 * ElementType.METHOD
 * ElementType.PARAMETER
 * ElementType.CONSTRUCTOR
 * ElementType.LOCAL_VARIABLE
 * ElementType.ANNOTATION_TYPE (on another annotation)
 * ElementType.PACKAGE (remember package-info.java)
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dalcontroller {
	String value();
}
