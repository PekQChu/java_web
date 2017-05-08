package com.shu.tool;

import java.util.HashMap;

public class  ConfigHaspMap
{
	private  HashMap<String,String> config;
	public ConfigHaspMap()
	{
		config=new HashMap<String,String>();
	}
	public String get(String key)
	{
		return config.get(key);
	}
	public void setConfig (HashMap<String,String> cfg) {
		this.config= cfg;
	}

	public HashMap<String,String> getConfig () {
		return config;
	}
}