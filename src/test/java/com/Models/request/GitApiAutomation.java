package com.Models.request;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Models.response.CreateRepoPOJO;
import com.Models.response.UpdatePOJO;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GitApiAutomation {
private static String mytoken="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";
	
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://api.github.com/";
	}
	
	@Test
	public void GetSingleRepoPOJO() {
		Header header=new Header("token",mytoken);
		Response res=RestAssured
		.given()
		.header(header)
		.when()
		.get("/repos/chivateneha/SeleniuTestNG");
		res.prettyPrint();
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		res.prettyPrint();
	}
	
     @Test	
     public void GetSingleNonExistRepo(){
	 Header header=new Header("token",mytoken);
		Response res=RestAssured
		.given()
		.header(header)
		.when()
		.get("/repos/chivateneha/Selenium");
		res.prettyPrint();

		res
		.then()
		.statusCode(404)
		.contentType(ContentType.JSON);
		res.prettyPrint();
 }
   @Test
    public void GetAllRepos() {
    	Header header =new Header("token",mytoken);
    	Response res= RestAssured
    			.given()
    			.header(header)
    			.when()
    			.get("user/repos");
    			res.prettyPrint();
    			
    			res
    			.then()
    			.statusCode(200)
    			.contentType(ContentType.JSON);
    			res.prettyPrint();
	
}
   @Test
  public void CreateNewRepo() {
		Header header = new Header("token",mytoken);
		CreateRepoPOJO data= new CreateRepoPOJO();
		data.setName("Hello-World");
		data.setDescription("This is your first repo!");
		data.setHomepage("https://api.github.com/");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("user/repos");	
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON);
  }
   
   public void CreateExistingRepo() {
	   Header header = new Header("token",mytoken);
		CreateRepoPOJO data= new CreateRepoPOJO();
		data.setName("Hello-World");
		data.setDescription("This is your first repo!");
		data.setHomepage("https://api.github.com/");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("user/repos");	
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON);
	   
	   
   }
   
   @Test
   public void UpdateRepo() {
		Header header = new Header("token",mytoken);
		UpdatePOJO data= new UpdatePOJO();
		data.setName("byebye-World1");
		data.setDescription("my repository created using apis after update");
		data.setPrivate("false");
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.patch("user/repos/chivateneha/Hello-World2");	
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
	}
   
   @Test
   public void DeleteRepo() {
		Header header = new Header("token",mytoken);
		//UpdatePOJO data = new UpdatePOJO();
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.when()
		        .delete("/repos/chivateneha/Hello-World2");	
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
		System.out.println(res.body());
		
	}
   @Test
   public void DeleteNonExist() {
	   Header header = new Header("token",mytoken);
		UpdatePOJO data = new UpdatePOJO();
		Response res=RestAssured
				.given()
				.header(header)
				.contentType(ContentType.JSON)
				.when()
		        .delete("/repos/chivateneha/byebye1");	
		
		res
		.then()
		.statusCode(404)
		.contentType(ContentType.JSON);
		
		System.out.println(res.body());
		
	   
   }
   
   }
   
   

