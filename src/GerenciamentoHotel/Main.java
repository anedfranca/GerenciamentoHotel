package GerenciamentoHotel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Hospede[] listaHospedes;
	
	public static void main(String[] args) throws IOException {
		
		GerenciamentoQuartoService gerenciamentoQuartos = new GerenciamentoQuartoService();
		GerenciadorHospedesService gerenciadorHospedesService = new GerenciadorHospedesService();
		GerenciadorFuncionariosService gerenciadorFuncionariosService = new GerenciadorFuncionariosService();
		GerenciadorPessoasService gerenciadorPessoasService = new GerenciadorPessoasService();
		GerenciadorReservasService gerenciadorReservasService = new GerenciadorReservasService();

		
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
						case 3: // Historico de estadias
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
					System.out.println("\n1. Reservar");
					System.out.println("2. Cancelar reserva");
					System.out.println("3. Verificar disponibilidade de quartos");
					System.out.println("4. Voltar");
					
					System.out.print("\nDigite a opcao desejada: ");
					op2 = sc.nextInt();
					sc.nextLine();
					
					switch (op2) {
					case 1: // Reservar
						
					    // Hospede titular, Quarto quarto, String tipoQuarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
						System.out.print("\nDigite o cpf do Hospede: ");
						String cpfHospede = sc.nextLine();
						
						if (!gerenciadorPessoasService.isCpfValid(cpfHospede)) {
							throw new IOException("CPF inválido.");
						} else if (!gerenciadorHospedesService.achouHospede(cpfHospede)) {
							System.out.print("\nHOSPEDE NÃO ENCONTRADO\n");
							continue;
						}
						
						String tipoQuarto = GerenciamentoQuartoService.lerTipoQuarto("Digite o tipo do quarto (solteiro, casal, suíte): ", sc);
						
						boolean temDisponivel = false;
						for (Quarto quarto : gerenciamentoQuartos.listarQuartosDisponiveis()) {
							if (quarto.getTipo().equalsIgnoreCase(tipoQuarto)) {
								temDisponivel = true;
							}
						}
						
						if (!temDisponivel) {
							System.out.print("\nNenhum quarto do tipo " + tipoQuarto + " disponivel\n");
							continue;
						}
						
						Integer qtdeHospedes = GerenciamentoQuartoService.lerInteiroPositivo("Digite a quantidade de hospedes: ", sc);
						
						System.out.print("\nDigite a data de inicio da hospedagem: ");
						String dataInicio = sc.nextLine();
						LocalDate dataInicioTratada = gerenciadorReservasService.recebeData(dataInicio);
						
						System.out.print("\nDigite a data de fim da hospedagem: ");
						String dataFim = sc.nextLine();
						LocalDate dataFimTratada = gerenciadorReservasService.recebeData(dataFim);

//						if (dataFimTratada <= dataInicioTratada) {
//							// SAMARA
//							// A BIBLIOTECA PADRAO DO JAVA PARA LIDAR COM DATAS
//							// NAO SABE COMPARAR DUAS DATAS??????
//						}
						
						System.out.println();

						// ver se ele tem disp na data
						ArrayList<Integer> numerosDisponiveis = new ArrayList<>();
						temDisponivel = false;
						for (Quarto quarto : gerenciamentoQuartos.listarQuartosDisponiveis()) {
							if (quarto.getTipo().equalsIgnoreCase(tipoQuarto) && quarto.getCapacidade() >= qtdeHospedes) {
								System.out.print(quarto);
								numerosDisponiveis.add(quarto.getNumero());
								temDisponivel = true;
							}
						}
						
						if (temDisponivel) {
							System.out.print("\nDigite o número do quarto desejado: ");
							Integer numero = sc.nextInt();
							sc.nextLine();
							
							if (numerosDisponiveis.contains(numero)) {
								Hospede hospede = gerenciadorHospedesService.buscarHospede(cpfHospede);
								Quarto quarto = gerenciamentoQuartos.buscarQuarto(numero);
								
								Reserva reserva = new Reserva(hospede, quarto, qtdeHospedes, dataInicioTratada, dataFimTratada);
								
								System.out.println();
								gerenciamentoQuartos.atualizarStatusQuarto(numero, "ocupado");
								System.out.println("Quarto reservado com Sucesso!");
							} else {
								System.out.print("\nNumero de quarto inválido");
								System.out.println("\nCancelando pedido de reserva...");
							}
						} else {
							System.out.println("\nNenhum quarto disponível :c ");
						}
						
					break;
					case 2: // Cancelar reserva
						//
					break;
					case 3: // Verificar disponibilidade de quartos
						gerenciamentoQuartos.listarQuartos();
					break;
					case 4: // Voltar
						//
					break;
					}
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
