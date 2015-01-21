package com.qt.watch.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URLEncoder;

public class HttpInvoker {

	private static String getStaticPage(String surl) {
		String htmlContent = "";
		try {
			java.io.InputStream inputStream;
			java.net.URL url = new java.net.URL(surl);
			java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url
					.openConnection();
			connection.connect();
			inputStream = connection.getInputStream();
			byte[] bytes = new byte[1024 * 2000];
			int index = 0;
			int count = inputStream.read(bytes, index, 1024 * 2000);
			while (count != -1) {
				index += count;
				count = inputStream.read(bytes, index, 1);
			}
			htmlContent = new String(bytes, "UTF-8");
			System.out.println(htmlContent);
			connection.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return htmlContent.trim();
	}

	public static void main(String[] args) {
		try {
			String src = getStaticPage(POST_URL);
			// File file = new File("d:\\aa.html");
			// FileWriter resultFile = new FileWriter(file);
			// PrintWriter myFile = new PrintWriter(resultFile);// 写文件
			// myFile.println(src);
			// resultFile.close();
			// myFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final String POST_URL = "http://ec2-54-169-209-8.ap-southeast-1.compute.amazonaws.com/api/findAll";

	public static void readContentFromPost() throws IOException {

		// Post请求的url，与get不同的是不需要带参数

		URL postUrl = new URL(POST_URL);

		// 打开连接

		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();

		// 打开读写属性，默认均为false

		connection.setDoOutput(true);

		connection.setDoInput(true);

		// 设置请求方式，默认为GET

		connection.setRequestMethod("POST");

		// Post 请求不能使用缓存

		connection.setUseCaches(false);

		// URLConnection.setFollowRedirects是static 函数，作用于所有的URLConnection对象。

		// connection.setFollowRedirects(true);

		// URLConnection.setInstanceFollowRedirects 是成员函数，仅作用于当前函数

		connection.setInstanceFollowRedirects(true);

		// 配置连接的Content-type，配置为application/x-
		// www-form-urlencoded的意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode进行编码

		// 连接，从postUrl.openConnection()至此的配置必须要在 connect之前完成，

		// 要注意的是connection.getOutputStream()会隐含的进行调用 connect()，所以这里可以省略

		// connection.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String line;

		System.out.println(" ============================= ");

		System.out.println(" Contents of post request ");

		System.out.println(" ============================= ");

		while ((line = reader.readLine()) != null) {

			System.out.println(line);

		}

		System.out.println(" ============================= ");

		System.out.println(" Contents of post request ends ");

		System.out.println(" ============================= ");

		reader.close();

		connection.disconnect();

	}

}