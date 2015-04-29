package com.sparkjava.tomcat;

import static spark.Spark.get;
import spark.servlet.SparkApplication;

public class Main implements SparkApplication {
	
	public void init() {
		get("/hello", (request, response) -> {
			return "Ok, Success";
		});
	}
}