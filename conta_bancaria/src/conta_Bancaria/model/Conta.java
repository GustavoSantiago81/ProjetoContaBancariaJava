package conta_Bancaria.model;

import conta_Bancaria.util.Cores;

public abstract class Conta {

	private int numero;
	private int agencia;
	private int tipos;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipos, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipos = tipos;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipos() {
		return tipos;
	}

	public void setTipos(int tipos) {
		this.tipos = tipos;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor1) {
		if (this.getSaldo() < valor1) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\nSaldo Insuficiente!" + Cores.TEXT_RESET);
			return false;
		} else

		this.setSaldo(this.getSaldo() - valor1);
		return true;

	}

	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public void visualizar() {

		String tipos = "";

		switch (this.tipos) {
		case 1 -> tipos = "Conta Corrente";
		case 2 -> tipos = "Conta Corrente";
		}

		System.out.println("************************************");
		System.out.println("		DADOS DA CONTA				");
		System.out.println("************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Número da Agência: " + this.agencia);
		System.out.println("Tipo de conta: " + tipos);
		System.out.println("Nome do Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo);
	}
}
