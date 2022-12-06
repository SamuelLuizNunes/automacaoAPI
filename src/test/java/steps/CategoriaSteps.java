package steps;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import maps.LoginMap;
import utils.RestUtils;

public class CategoriaSteps {
	
	Map<String, String> header = new HashMap<>();
	

	@Dado("que tenha um payload da API de Categoria")
	public void queTenhaUmPayloadDaAPIDeCategoria() {
		header.put("Authorization", "Bearer " + LoginMap.token);
	}
	
	@Quando("realizo uma requisicao do tipo Get de Categoria")
	public void realizoUmaRequisicaoDoTipoGetDeCategoria() {
	    RestUtils.get(header, "categorias");
	}
	
	@Quando("altero o campo {string} do header de categorias com o valor {string}")
	public void alteroOCampoDoHeaderDeCategoriasComOValor(String key, String value) {
	    header.put(key, value);
	}

}
