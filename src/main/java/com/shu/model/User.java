package com.shu.model;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.JSON;
import com.shu.model.enums.UserRole;

@Entity  //实体
@Table(name="user")  //表名
public class User {
	public final static String CUR_USER = "cur_user";
	
	public User()
	{
		type = UserRole.User.getLevel();
	}
	@Id     //
    @GeneratedValue   
	private long id;  //
	private String username;
	private String password;
	private String phone;
	private String email;
	private int type;
	
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date loginDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
