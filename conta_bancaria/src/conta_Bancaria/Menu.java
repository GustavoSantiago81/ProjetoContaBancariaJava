package conta_Bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_Bancaria.model.Conta;
import conta_Bancaria.model.ContaCorrente;
import conta_Bancaria.model.ContaPoupanca;
import conta_Bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		// Criamos o Objeto Conta c1
		Conta c1 = new Conta(1, 123, 1, "Erica Araújo", 30000.0f);

		// Visualizamos os dados da Conta c1
		c1.visualizar();

		// Alteramos os Dados da Conta c1
		c1.setSaldo(35000.0f);

		// Visualizamos o saldo da Conta c1
		System.out.println("\n\n" + c1.getSaldo());

		// Criamos o Objeto Conta c2
		Conta c2 = new Conta(2, 132, 1, "Dener Cardoso", 50000.0f);

		// Visualizamos os dados da Conta c2
		c2.visualizar();

		// Efetuamos um saque na Conta c2
		if (c2.sacar(100000.0f))
			System.out.println("\n\n" + c2.getSaldo());

		// Efetuamos um deposito na Conta c2
		c2.depositar(1000.0f);

		// Visualizamos um saque na Conta c1
		c1.getSaldo();

		ContaCorrente c3 = new ContaCorrente(3, 123, 1, "Vitoria", 30000.0f, 1000.0f);

		c3.visualizar();

		c3.sacar(31001);

		c3.visualizar();
		
		ContaPoupanca c4 = new ContaPoupanca(4, 123, 2, "Lia", 20000.0f, 5);
		
		c4.visualizar();

		int opcao;
		int numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Tipo da conta (1 - CC | 2 - CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.println("Limite da Conta Corrente: ");
						limite = leia.nextInt();
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
	
						cc.visualizar();
					}

					case 2 -> {
						System.out.println("Aniversário da Conta: ");
						aniversario = leia.nextInt();
						ContaCorrente cp = new ContaCorrente(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}

				keyPress();

			case 2:
				System.out.println("Listar todas as Contas\n\n");
				
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				System.out.println("Número da Conta: ");
				numero = leia.nextInt();

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				// Condicional para verificação de Conta Existente
				
				System.out.println("Número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				// Busca do tipo
				tipo = 0;

				System.out.println("Saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.println("Limite da Conta Corrente: ");
						limite = leia.nextInt();
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 -> {
						System.out.println("Aniversário da Conta: ");
						aniversario = leia.nextInt();
						ContaCorrente cp = new ContaCorrente(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				// Chamada para o Método Deletar
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = leia.nextFloat();
				
				// Chamada para o Método Sacar
				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = leia.nextFloat();
				
				// Chama para o Método Depositar

				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				
				System.out.println("Número da Conta - Origem: ");
				numero = leia.nextInt();
				
				System.out.println("Número da Conta - Destino: ");
				numeroDestino = leia.nextInt();
				
				System.out.println("Valor da Transferência: ");
				valor = leia.nextFloat();
				
				// Chamada para o Método Transferir
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}