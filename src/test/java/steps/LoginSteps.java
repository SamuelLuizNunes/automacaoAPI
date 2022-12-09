package steps;

import java.util.Map;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

public class LoginSteps {
	@Dado("que tenha um payload valido da API de Login")
	public void queTenhaUmPayloadValidoDaAPIDeLogin() {
		LoginMap.initLogin();
	}
	
	@Dado("que tenha um payload da API de Login com as seguintes informacoes")
	public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformacoes(Map<String, Object> map) {
		LoginMap.initLogin();
		LoginMap.getLogin().putAll(map);
	}
	
	@Quando("envio uma requisicao do tipo POST de Login")
	public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
		RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
	}
	
	@Entao("armazeno o token que recebo do response de Login")
	public void armazenoOTokenQueReceboDoResponseDeLogin() {
	    LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
	}
	
	@Dado("que tenha realizado o login com dados validos")
	public void queTenhaRealizadoOLoginComDadosValidos() {
		queTenhaUmPayloadValidoDaAPIDeLogin();
		envioUmaRequisicaoDoTipoPOSTDeLogin();
		armazenoOTokenQueReceboDoResponseDeLogin();
	}
}
