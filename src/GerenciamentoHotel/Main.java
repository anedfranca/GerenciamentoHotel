package GerenciamentoHotel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GerenciadorHospedesService gerenciadorHospedesService = new GerenciadorHospedesService();
		GerenciadorFuncionariosService gerenciadorFuncionariosService = new GerenciadorFuncionariosService();
		
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
					//
				break;
			}
		}
	}
}
