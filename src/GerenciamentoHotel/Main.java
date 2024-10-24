package GerenciamentoHotel;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Hospede> listaHospedes = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int op1, op2;
		
		while (true) {
			System.out.println("\n1. Quartos");
			System.out.println("2. Hospedes");
			System.out.println("3. Reservas");
			System.out.println("4. Funcionarios");
			System.out.println("5. Check-in/Check-out");
			System.out.println("6. Sair\n");
			
			System.out.print("Digite a opcao desejada: ");
			op1 = sc.nextInt();
			
			switch (op1) {
				case 1:
					//
				break;
				case 2:
					System.out.println("\n1. Cadastrar novo Hospede");
					System.out.println("2. Editar Hospede");
					System.out.println("3. Historico de estadias");
					System.out.println("4. Voltar para menu princial");
					
					System.out.print("Digite a opcao desejada: ");
					op2 = sc.nextInt();
					
					switch (op2) {
						case 1:
							sc.nextLine();
							System.out.print("\nDigite o nome do hospede: ");
							String nome = sc.nextLine();
							System.out.print("\nDigite o CPF do hospede: ");
							String cpf = sc.nextLine();
							System.out.print("\nDigite a data de nascimento do hospede: ");
							String dataNasc = sc.nextLine();
							System.out.print("\nDigite o endereco do hospede: ");
							String endereco = sc.nextLine();
							System.out.print("\nDigite o telefone de contato do hospede: ");
							String telefone = sc.nextLine();
							
							Date data = new Date();
							
							Hospede hospede = new Hospede(nome, cpf, data, endereco, telefone);
							
							listaHospedes.add(hospede);
							
							System.out.println("\nHospede Cadastrado com Sucesso!\n");
							
							System.out.println(listaHospedes.get(0));
						break;
						case 2:
							sc.nextLine();
							System.out.print("\nDigite o CPF do hospede que voce deseja editar: ");
							String cpfEditar = sc.nextLine();
							
							// Encontrar Hospede
							for (Hospede h : listaHospedes) {								
								if (h.getCpf().equalsIgnoreCase(cpfEditar)) { // Encontrou
									System.out.print("\nDigite o nome corrigido do hospede: ");
									String nomeNovo = sc.nextLine();
									
									h.setNome(nomeNovo);

									System.out.print("\nDigite a data de nascimento corrigida do hospede: ");
									String dataNascNova = sc.nextLine();
									
									Date dataNova = new Date();
									h.setDataNasc(dataNova);
									
									System.out.print("\nDigite o novo endereco do hospede: ");
									String enderecoNovo = sc.nextLine();
									h.setEndereco(enderecoNovo);
									
									System.out.print("\nDigite o telefone de contato corrigido do hospede: ");
									String telefoneNovo = sc.nextLine();
									h.setNumeroContato(telefoneNovo);
									
									System.out.println("\nHospede Cadastrado com Sucesso!\n"); // TESTAR FUNCIONALIDADE - PRECISO CRIAR METODO STR
								}
							}
						break;
						case 3:
							//
						break;
						case 4:
							//
						break;
					}
				break;
				case 3:
					//
				break;
				case 4:
					//
				break;
				case 5:
					//
				break;
				case 6:
					//
				break;
			}
		}
	}
}
