package conta_Bancaria.controller;

import java.util.ArrayList;

import conta_Bancaria.model.Conta;
import conta_Bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	@Override
	public void procuraPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		//listaContas.get(numero)
		
		if(conta == null)
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
		else
			conta.visualizar();
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas)
			conta.visualizar();

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		conta.visualizar();
		System.out.println("A conta foi criada");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A Conta número: " + conta.getNumero() + " não foi encontrada!");
		}else
			System.out.println("A Conta número: " + conta.getNumero() + " foi atualizada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("A Conta número: " + numero + " foi excluída!");
		}else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numero, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	/* Implementar Métodos Auxiliares */
		
	public int gerarNumero() {
		return (listaContas.size() + 1);
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return conta;
		}
		
		return null;
	}
	
	public int retornaTipo(int numero) {
		
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return conta.getTipos();
		}
		
		return 0;
	}
}
