package com.shu.model.enums;

public enum UserRole {
   ADMIN(1000,"系统管理员"),
   User(100,"普通用户"),
   Developer(10,"开发者");
	
	private int level;
	private String identity;
	
	UserRole(int level, String identity){
		this.level=level;
		this.identity=identity;
	}
	 @Override
	    public String toString() {
	        return this.identity;
	    }

	    public int getLevel() {
	        return level;
	    }

	    public static UserRole parse(int value) {
	        switch (value) {
	            case 1000:
	                return ADMIN;
	            case 100:
	                return User;
	            case 10:
	                return Developer;
	        }
	        return null;
	    }
}
