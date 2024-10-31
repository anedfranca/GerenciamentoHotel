package GerenciamentoHotel;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		GerenciamentoQuartoService gerenciamentoQuartos = new GerenciamentoQuartoService();
		GerenciadorHospedesService gerenciadorHospedesService = new GerenciadorHospedesService();
		GerenciadorFuncionariosService gerenciadorFuncionariosService = new GerenciadorFuncionariosService();
		private static Hospede[] listaHospedes;
    
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
					System.out.println("\n1. Cadastrar novo Quarto");
                    System.out.println("2. Listar Quartos Disponíveis");
                    System.out.println("3. Atualizar Status de um Quarto");
                    System.out.println("4. Voltar para menu principal");
                    
                    System.out.print("Digite a opção desejada: ");
                    op2 = sc.nextInt();
                    sc.nextLine(); 
                    
                    switch (op2) {
                        case 1:
                            int numero = GerenciamentoQuartoService.lerInteiroPositivo("Digite o número do quarto: ", sc);
                            String tipo = GerenciamentoQuartoService.lerTipoQuarto("Digite o tipo do quarto (solteiro, casal, suíte): ", sc);
                            int capacidade = GerenciamentoQuartoService.lerInteiroPositivo("Digite a capacidade do quarto: ", sc);
                            double preco = GerenciamentoQuartoService.lerDoublePositivo("Digite o preço da diária: ", sc);
                            
                            Quarto novoQuarto = new Quarto(numero, tipo, capacidade, preco);
                            gerenciamentoQuartos.cadastrarQuarto(novoQuarto);
                        break;
                        
                        case 2:
                            System.out.println("Quartos disponíveis:");
                            for (Quarto quarto : gerenciamentoQuartos.listarQuartosDisponiveis()) {
                                System.out.println(quarto);
                            }
                        break;
                        
                        case 3:
                            int numeroQuarto = GerenciamentoQuartoService.lerInteiroPositivo("Digite o número do quarto para atualizar o status: ", sc);
                            String novoStatus = GerenciamentoQuartoService.lerStatusQuarto("Digite o novo status (disponível, ocupado, em manutenção): ", sc);
                            gerenciamentoQuartos.atualizarStatusQuarto(numeroQuarto, novoStatus);
                        break;
                        
                        case 4:
                        break;
                   
                    }
                break;
				case 2:
					System.out.println("\n1. Cadastrar novo Hospede");
					System.out.println("2. Editar Hospede");
					System.out.println("3. Historico de estadias");
					System.out.println("4. Voltar para menu princial");
					
					System.out.print("\nDigite a opcao desejada: ");
					op2 = sc.nextInt();
					
					switch (op2) {
						case 1: // cadastrar hospede
							sc.nextLine();
							
							gerenciadorHospedesService.cadastrarHospede();
							
						break;
						case 2: // Editar um hospede
							sc.nextLine();
							System.out.print("\nDigite o CPF do hospede que voce deseja editar: ");
							String cpfEditar = sc.nextLine();
							
							gerenciadorHospedesService.editarHospede(cpfEditar);
							
						break;
						case 3:
							// precisa ter resereva pronto!!
						break;
						case 4:
							// voltar
						break;
						default:
							System.out.println("Opção inválida!\n");
					}
				break;
				case 3:
					//
				break;
				case 4: // Funcionarios
					
					System.out.println("\n1. Cadastrar novo Funcionario");
					System.out.println("2. Editar Funcionario");
					System.out.println("3. Cadastrar horas");
					System.out.println("4. Calcular salario");
					System.out.println("5. Voltar");
					
					System.out.print("\nDigite a opcao desejada: ");
					op2 = sc.nextInt();
					
					switch (op2) {
					case 1: // Cadastrar Funcionario
						sc.nextLine();
						
						gerenciadorFuncionariosService.cadastrarFuncionario();
					break;
					case 2: // Editar Funcionario
						sc.nextLine();
						System.out.print("\nDigite o CPF do funcionario que voce deseja editar: ");
						String cpf = sc.nextLine();
						
						gerenciadorFuncionariosService.editarfuncionario(cpf);
					break;
					case 3: // Cadastrar horas
						sc.nextLine();

						System.out.print("\nDigite o CPF do funcionario que voce deseja cadastrar as horas: ");
						String cpfFunc = sc.nextLine(); 
						
						gerenciadorFuncionariosService.cadastrarHoras(cpfFunc);
						
					break;
					case 4:
						// Calcular Salario
						sc.nextLine();

						System.out.print("\nDigite o CPF do funcionario que voce deseja calcular o salario: ");
						String cpfF = sc.nextLine(); 
						
						gerenciadorFuncionariosService.calcularSalario(cpfF);
						
					break;
					case 5: // Voltar
					break;
					default:
						System.out.println("Opção inválida!\n");
				}
				break;
				case 5:
					//
				break;
				case 6:
					System.out.println("\nSaindo do programa...");
					System.exit(0);
				break;
			}
		}
	}
}
