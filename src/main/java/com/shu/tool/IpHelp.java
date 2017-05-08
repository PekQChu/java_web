package com.shu.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class IpHelp {
	public static String AK ="Omfo8nQYAzIgV3Fpgzdixl3y";
	public static String Url="http://api.map.baidu.com/location/ip";
	public static String coor="bd09ll";
	static String RequestFromServer(List<NameValuePair> pair,BasicResponseHandler handler) throws ClientProtocolException, IOException
	{
		HttpClient httpclient;// 实例化提交实例，由于提交
		HttpPost post;// 实例化post实例，url是提交地址
		httpclient = new DefaultHttpClient();// 实例化提交实例，由于提交
		post = new HttpPost(Url);// 实例化post实例，url是提交地址
		if(null==pair)
		{
			pair = new ArrayList<NameValuePair>();
		}
		pair.add(new BasicNameValuePair("ak", AK));
		pair.add(new BasicNameValuePair("coor", coor));
		post.setEntity(new UrlEncodedFormEntity(pair, HTTP.UTF_8));// 设定提交数据的编码方式
		String results = httpclient.execute(post, handler);// 提交数据并接受返回值
		return results;
	}
	public static String  get_info_by_ip(String ip){
		List<NameValuePair> pair=new ArrayList<NameValuePair>();
		pair.add(new BasicNameValuePair("ip", ip));
		String city="";
		try {
			String result=RequestFromServer(pair,new BasicResponseHandler());
			JSONObject rjobj=new JSONObject(result);
			System.out.println(rjobj);
			if(rjobj.getInt("status")==0){
		    city=rjobj.getJSONObject("content").getJSONObject("address_detail").getString("city");
			city =city+" " +rjobj.getJSONObject("content").getJSONObject("address_detail").getString("city");
			System.out.println("查询到的城市为："+city);
			}
			return city;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return city;
	}
	public static void main(String args[]){
		get_info_by_ip("202.120.119.138");
	}
}
