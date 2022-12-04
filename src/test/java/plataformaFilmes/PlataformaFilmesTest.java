package plataformaFilmes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PlataformaFilmesTest {
	
	static String token;
	
	@BeforeAll
	public static void validarLoginMap() {
		RestAssured.baseURI = "http://192.168.0.6:8080/";
		Map<String, String> map = new HashMap<>();
		map.put("email", "aluno@email.com");
		map.put("senha", "123456");
		
		Response response = post(map, ContentType.JSON, "auth");
		
		assertEquals(200, response.statusCode());
		token = response.jsonPath().get("token");	
		System.out.println(token);
	}
	
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
	
	@Test
	public void validarConsultaCategorias() {
		Map<String, String> header = new HashMap<>();
		header.put("Authorization", "Bearer " + token);
		
		Response response = get(header, "categorias");
		assertEquals(200, response.statusCode());
		
		System.out.println(response.jsonPath().get().toString());
		
		
	}
	
	public static Response get(Map<String, String> header, String endpoint) {
		return RestAssured.given()
				.relaxedHTTPSValidation()
				.headers(header)
				.when()
				.get(endpoint)
				.thenReturn();
	} 
	
	public static Response post(Object json, ContentType contentType, String endpoint) {
		return RestAssured.given()
				.relaxedHTTPSValidation()		
				.contentType(contentType)
				.body(json)
				.when()
				.post(endpoint)
				.thenReturn();
	}
	
}



