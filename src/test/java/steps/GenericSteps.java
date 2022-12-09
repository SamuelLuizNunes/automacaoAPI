package steps;

import java.util.ArrayList;

import org.junit.Assert;

import io.cucumber.java.pt.Entao;
import utils.RestUtils;

public class GenericSteps {

	@Entao("valido que recebo status {int} no response")
	public void validoQueReceboStatusNoResponse(int status) {
	    Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());
	}
	
	@Entao("valido que no campo {string} possui o valor {string}")
	public void validoQueNoCampoPossuiOValor(String key, String value) {
	    Assert.assertEquals(value, RestUtils.getResponse().jsonPath().get(key));
	}
	
	@Entao("valido que recebo uma lista vazia no response")
	public void validoQueReceboUmaListaVaziaNoResponse() {
	    Assert.assertEquals(new ArrayList<>(), RestUtils.getResponse().jsonPath().get());
	}
}
