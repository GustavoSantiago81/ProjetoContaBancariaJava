package conta_Bancaria.model;

import conta_Bancaria.util.Cores;

public class ContaCorrente extends Conta{

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipos, String titular, float saldo, float limite) {
		super(numero, agencia, tipos, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}
	
	@Override
	public boolean sacar(float valor1) {
		if (this.getSaldo() + this.getLimite() < valor1) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\nSaldo Insuficiente!" + Cores.TEXT_RESET);
			return false;
		} else

		this.setSaldo(this.getSaldo() - valor1);
		return true;

	}
}
