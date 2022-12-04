package plataformaFilmes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RestUtils;

public class PlataformaFilmesTest {
	
	static String token;
	
	@BeforeAll
	public static void validarLoginMap() {
		RestUtils.setBaseURI("http://192.168.0.6:8080/");
		Map<String, String> map = new HashMap<>();
		map.put("email", "aluno@email.com");
		map.put("senha", "123456");
		
		Response response = RestUtils.post(map, ContentType.JSON, "auth");
		
		assertEquals(200, response.statusCode());
		token = response.jsonPath().get("token");	
	}
	
	@Test
	public void validarLogin() {
		RestUtils.setBaseURI("http://192.168.0.6:8080/");
		
		String json = "{"
				+ "    \"email\": \"aluno@email.com\","
				+ "    \"senha\": \"123456\""
				+ "}";
		
		Response response = RestUtils.post(json, ContentType.JSON, "auth");
		assertEquals(200, response.statusCode());
	}
	
	@Test
	public void validarConsultaCategorias() {
		Map<String, String> header = new HashMap<>();
		header.put("Authorization", "Bearer " + token);
		Response response = RestUtils.get(header, "categorias");
		assertEquals(200, response.statusCode());
		System.out.println(response.jsonPath().get().toString());
		assertEquals("Terror", response.jsonPath().get("tipo[2]"));		
		List<String> listTipo = response.jsonPath().get("tipo");
		assertTrue(listTipo.contains("Terror"), "Não foi encontrado a categoria Romance na lista de categorias");
		
	}
}



