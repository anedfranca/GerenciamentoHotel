package GerenciamentoHotel;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Hospede> listaHospedes = new ArrayList();
		ArrayList<Funcionario> listaFuncionarios = new ArrayList();
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
					// pedro
				break;
				case 2:
					System.out.println("\n1. Cadastrar novo Hospede");
					System.out.println("2. Editar Hospede");
					System.out.println("3. Historico de estadias");
					System.out.println("4. Voltar para menu princial");
					
					System.out.print("\nDigite a opcao desejada: ");
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
						break;
						case 2:
							Boolean achou = false;
							
							sc.nextLine();
							System.out.print("\nDigite o CPF do hospede que voce deseja editar: ");
							String cpfEditar = sc.nextLine();
							
							// Encontrar Hospede
							for (Hospede h : listaHospedes) {								
								if (h.getCpf().equalsIgnoreCase(cpfEditar)) { // Encontrou
									achou = true;
									
									System.out.println("Hospede " + h.getNome() + ", encontrado com sucesso!");
									
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
									
									System.out.println("\nHospede Editado com Sucesso!\n");
									break;
								}
							}
							if (!achou) {
								System.out.println("\nCPF nao encontrado...\n");								
							}
						break;
						case 3:
							//
						break;
						case 4:
							//
						break;
						default:
							System.out.println("Opção inválida!\n");
					}
				break;
				case 3:
					//
				break;
				case 4:
					// Funcionarios
					
					System.out.println("\n1. Cadastrar novo Funcionario");
					System.out.println("2. Editar Funcionario");
					System.out.println("3. Cadastrar horas");
					System.out.println("4. Calcular salario");
					System.out.println("5. Voltar");
					
					System.out.print("\nDigite a opcao desejada: ");
					op2 = sc.nextInt();
					
					switch (op2) {
					case 1:
						// Cadastrar Funcionario
						sc.nextLine();
						System.out.print("\nDigite o nome do funcionario: ");
						String nome = sc.nextLine();
						System.out.print("\nDigite o CPF do funcionario: ");
						String cpf = sc.nextLine();
						System.out.print("\nDigite o cargo do funcionario: ");
						String cargo = sc.nextLine();
						System.out.print("\nDigite o turno de trabalho: ");
						String turnoDeTrabalho = sc.nextLine();
						
						Funcionario funcionario = new Funcionario(nome, cpf, cargo, turnoDeTrabalho);
						
						listaFuncionarios.add(funcionario);
						
						System.out.println(listaFuncionarios.get(0));
						
						System.out.println("\nFuncioario " + funcionario.getNome() + ", cadastrado com Sucesso!\n");
					break;
					case 2:
						Boolean achou = false;
						
						sc.nextLine();
						System.out.print("\nDigite o CPF do funcionario que voce deseja editar: ");
						String cpfEditar = sc.nextLine();
						
						// Encontrar Funcionario
						for (Funcionario f : listaFuncionarios) {								
							if (f.getCpf().equalsIgnoreCase(cpfEditar)) { // Encontrou
								achou = true;
								
								System.out.println("Funcionario " + f.getNome() + ", encontrado com sucesso!");
								
								System.out.print("\nDigite o nome corrigido do funcionario: ");
								String nomeNovo = sc.nextLine();
								
								f.setNome(nomeNovo);

								System.out.print("\nDigite o cargo do funcionario: ");
								String cargoNovo = sc.nextLine();
								
								f.setCargo(cargoNovo);
								
								System.out.print("\nDigite o turno de trabalho do funcionario: ");
								String turnoNovo = sc.nextLine();
								f.setTurnoDeTrabalho(turnoNovo);
								
								System.out.println("\nFuncionario Editado com Sucesso!\n");
								break;
							}
						}
						if (!achou) {
							System.out.println("\nCPF nao encontrado...\n");								
						}
					break;
					case 3:
						// Cadastrar horas
						sc.nextLine();
						Boolean achouFunc = false;
						System.out.print("\nDigite o CPF do funcionario que voce deseja cadastrar as horas: ");
						String cpfFunc = sc.nextLine(); 
						
						for (Funcionario f : listaFuncionarios) {
							if (f.getCpf().equalsIgnoreCase(cpfFunc)) {
								achouFunc = true;
								
								System.out.print("\nDigite a quantidade de horas trabalhadas: ");
								Integer horasTrabalhadas = sc.nextInt();
								sc.nextLine();
								
								f.setQtdeHorasTrabalhadas(horasTrabalhadas);
								break;
							}
						}
						
						if (!achouFunc) {
							System.out.println("\nCPF nao encontrado...\n");
						}
						
					break;
					case 4:
						// Calcular Salario
						sc.nextLine();
						Boolean achouF = false;
						System.out.print("\nDigite o CPF do funcionario que voce deseja calcular o salario: ");
						String cpfF = sc.nextLine(); 
						
						for (Funcionario f : listaFuncionarios) {
							if (f.getCpf().equalsIgnoreCase(cpfF)) {
								achouF = true;
								
								System.out.println(f.calculaSalario());
								break;
							}
						}
						
						if (!achouF) {
							System.out.println("\nCPF nao encontrado...\n");
						}
						
					break;
					case 5:
						// Voltar
					break;
					default:
						System.out.println("Opção inválida!\n");
				}
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
