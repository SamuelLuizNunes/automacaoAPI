package transferencia;

public class Conta {

	private String agencia;
	private String numeroConta;
	private double saldo;
	private Cliente titular;

	public Conta(String agencia, String numeroConta, double saldo, Cliente titular) {
		super();
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public boolean sacar(double valor) {
		if (valor > this.saldo) {
			return false;
		}
		this.saldo -= valor;
		return true;
	}
	
	public boolean transferir(double valor, Conta titular) {
			if(sacar(valor)){
				titular.depositar(valor);
				return true;
			}
			return false;
	}
}
