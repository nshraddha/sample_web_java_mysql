package com.cloudmunch.javademo;

import static spark.Spark.get;
import static spark.Spark.put;
import spark.servlet.SparkApplication;
import java.sql.SQLException;

public class Main implements SparkApplication {
	public static void main(String[] args){
        System.setProperty("norm.dataSourceClassName", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        System.setProperty("norm.serverName", "localhost");
        System.setProperty("norm.databaseName", "restlogger");
        System.setProperty("norm.user", "root");
        System.setProperty("norm.password", "cloudmunch");
		
		SparkApplication app = new Main();
		app.init();
	}

	public void init(){
        try {
            RestLogger logger = new RestLogger();
    
            get("/echo", "application/json", (req, res) -> req.userAgent(), new JsonHelper());
            put("/echo", "application/json", (req, res) -> logger.echo(req.body()), new JsonHelper());
            put("/info", "application/json", (req, res) -> logger.info(req.body()), new JsonHelper());
            put("/warn", "application/json", (req, res) -> logger.warn(req.body()), new JsonHelper());
            put("/error", "application/json", (req, res) -> logger.error(req.body()), new JsonHelper());
            put("/fatal", "application/json", (req, res) -> logger.fatal(req.body()), new JsonHelper());
    	            
        } catch(SQLException except){
            //Eating out the exception.
        }   
    }
}