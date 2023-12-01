package com.Models.request;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.*;
import com.Models.response.CreateRepoPOJO;
import com.Models.response.UpdatePOJO;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GitApiAutomation {

private static String mytoken2="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";
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://api.github.com/";
	}
	
	@Test
	public void GetSingleRepoPOJO() {
		Header header=new Header("token","mytoken2");
		
		Response res=RestAssured
		.given()
		//.header(header)
		.header("Authorization", "Bearer " + mytoken2)
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
	 Header header=new Header("token","mytoken2");
		Response res=RestAssured
		.given()
		.header("Authorization", "Bearer " + mytoken2)
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
    	Header header =new Header("token","mytoken2");
    	Response res= RestAssured
    			.given()
    			.header("Authorization", "Bearer " + mytoken2)
    			.when()
    			.get("user/repos");
    			res.prettyPrint();
    			
    			res
    			.then()
    			.statusCode(200)
    			.contentType(ContentType.JSON);
    			res.then()
    			 .assertThat().
    			    body(JsonSchemaValidator.matchesJsonSchema(new File ("C:\\Users\\Chiva\\java2023\\APITestFramework\\src\\test\\resources\\AllUserSchema.json")));

  
    			res.prettyPrint();
	            
}
   @Test
  public void CreateNewRepo() {
		Header header = new Header("token","mytoken2");
		CreateRepoPOJO data= new CreateRepoPOJO();
		data.setName("hello");
		data.setDescription("This is your first repo!");
		data.setHomepage("https://api.github.com/");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header("Authorization", "Bearer " + mytoken2)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("user/repos");	
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON);
		res.prettyPrint();
		
  }
   @Test
   public void CreateExistingRepo() {
	   Header header = new Header("token","mytoken");
		CreateRepoPOJO data= new CreateRepoPOJO();
		data.setName("Hello-World");
		data.setDescription("This is your first repo!");
		data.setHomepage("https://api.github.com/");
		data.setPrivate("false");
		
		Response res=RestAssured
				.given()
				.header("Authorization", "Bearer " + mytoken2)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("user/repos");	
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON);
		res.prettyPrint();
	   
   }
   
   @Test
   public void UpdateRepo() {
		Header header = new Header("token","mytoken2");
		UpdatePOJO data= new UpdatePOJO();
		data.setName("hello");
		data.setDescription("my repository created using apis after update");
		data.setPrivate("false");
		Response res=RestAssured
				.given()
				.header("Authorization", "Bearer " + mytoken2)
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.patch("/repos/chivateneha/byebye1");	
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		res.prettyPrint();
	}
   
   @Test
   public void DeleteRepo() {

		Header header = new Header("token","mytoken2");
		//UpdatePOJO data = new UpdatePOJO();
		Response res=RestAssured
				.given()
				.header("Authorization", "Bearer " + mytoken2)
				//.contentType(ContentType.JSON)
				.when()
		        .delete("/repos/chivateneha/hello");	
		
		res
		.then()
		.statusCode(204);
		//.contentType(ContentType.JSON);
		
		System.out.println(res.statusCode());
		
	}
   @Test
   public void DeleteNonExist() {
	   Header header = new Header("token","mytoken2");
		UpdatePOJO data = new UpdatePOJO();
		Response res=RestAssured
				.given()
				.header("Authorization", "Bearer " + mytoken2)
				//.contentType(ContentType.JSON)
				.when()
		        .delete("/repos/chivateneha/hello");	
		
		res
		.then()
		.statusCode(404);
		//.contentType(ContentType.JSON);
		
		System.out.println(res.statusCode());
		
	   
   }
   
   }
   
   

