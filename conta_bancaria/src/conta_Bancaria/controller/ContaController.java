package conta_Bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_Bancaria.model.Conta;
import conta_Bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procuraPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
		else
			conta.get().visualizar();
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas)
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
		Optional<Conta> buscaConta = buscarNaCollection(numero);

		if (buscaConta.isPresent()){
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A Conta número: " + conta.getNumero() + " não foi encontrada!");
		} else
			System.out.println("A Conta número: " + conta.getNumero() + " foi atualizada!");

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A Conta número: " + numero + " foi excluída!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");

	}

	@Override
	public void sacar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.println("O saque foi efetuado com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("O depósito foi efetuado com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void transferir(int numero, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numero);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
			if(contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("A transferência foi efetuado com sucesso!");
			}
		} else
			System.out.println("A Conta de Origem e/ou Destino não foram encontrada(s)!");
	}

	/* Implementar Métodos Auxiliares */

	public int gerarNumero() {

		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

	public int retornaTipo(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return conta.getTipos();
		}

		return 0;
	}
}
