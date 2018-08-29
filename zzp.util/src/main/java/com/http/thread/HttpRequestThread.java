package com.http.thread;

import java.util.Map;

import com.util.http.HttpRequest;

/**
 * «Î«Ûhttpœﬂ≥Ã
 * 
 * @author zzp
 * @since 2018.08.29
 *
 */
public class HttpRequestThread implements Runnable{

	private String url;
	
	private String appsecret;
	
	private Map<String, String> params;
	
	public HttpRequestThread(String url, String appsecret, Map<String, String> params) {
		this.url = url;
		this.appsecret = appsecret;
		this.params = params;
	}
	
	@Override
	public void run() {
		String result = HttpRequest.sendGet(url, appsecret, params);
		System.out.println(Thread.currentThread() + "£∫" + result);
	}
	
}
