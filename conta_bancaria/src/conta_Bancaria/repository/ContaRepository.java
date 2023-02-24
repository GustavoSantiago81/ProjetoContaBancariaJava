package conta_Bancaria.repository;

import conta_Bancaria.model.Conta;

public interface ContaRepository {

	public void procuraPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numero, int numeroDestino, float valor);
}
