package transferencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTeste {

	Cliente samuel;
	Cliente kaio;
	Conta contaSamuel;
	Conta contaKaio;

	@BeforeEach
	void setUp() {
		samuel = new Cliente("Samuel", "222.222.222-16", "55.555.555-6");
		kaio = new Cliente("Kaio", "555.555.555-18", "33.333.333-8");
		contaSamuel = new Conta("2222", "0122", 2500.00, samuel);
		contaKaio = new Conta("1111", "0222", 2000.00, kaio);
	}

	@Test
	public void realizarTransacao() {
		contaSamuel.transferir(500.00, contaKaio);
		Assertions.assertEquals(2000.00, contaSamuel.getSaldo());
		Assertions.assertEquals(2500.00, contaKaio.getSaldo());
	}

	@Test
	public void validarTransferenciaInvalida() {
		boolean resultado = contaSamuel.transferir(3500.00, contaKaio);
		Assertions.assertFalse(resultado);

	}
}
