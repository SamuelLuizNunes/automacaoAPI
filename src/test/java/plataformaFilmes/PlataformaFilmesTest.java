package plataformaFilmes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PlataformaFilmesTest {
	
	@Test
	public void validarLogin() {
		RestAssured.baseURI = "http://192.168.0.6:8080/";
		
		String json = "{"
				+ "    \"email\": \"aluno@email.com\","
				+ "    \"senha\": \"123456\""
				+ "}";
		
		Response response = post(json, ContentType.JSON, "auth");
		assertEquals(200, response.statusCode());
		String token = response.jsonPath().get("token");
		System.out.println(token);
	}
	
	public Response post(Object json, ContentType contentType, String endpoint) {
		return RestAssured.given()
				.relaxedHTTPSValidation()		
				.contentType(contentType)
				.body(json)
				.when()
				.post(endpoint)
				.thenReturn();
	}
}






