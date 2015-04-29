package com.cloudmunch.javademo;

import static spark.Spark.get;
import spark.servlet.SparkApplication;

public class Main implements SparkApplication {
	public static void main(String[] args){
		SparkApplication app = new Main();
		app.init();		
	}

	public void init() {
		get("/hello", (request, response) -> {
			return "Hello, World!";
		});
	}
}