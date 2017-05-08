package com.shu.tool;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
public @interface Permission {
	public static String SESSION_PERMISSION = "session_permision";
	public static long ADMIN =1000l;
	public static long USER = 100l;

	// public static long SELLER = 1;
	// public static long BUYER = 0;

	long value();

}