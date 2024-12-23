package GerenciamentoHotel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class GerenciadorFuncionariosService implements gerenciar {
	
	private ArrayList<Funcionario> listaFuncionarios;
	
	public GerenciadorFuncionariosService() {
		listaFuncionarios = new ArrayList<>();
	}
	
	public void addFuncionario(Funcionario f) {
		this.listaFuncionarios.add(f);
	}
	
	public void cadastrarFuncionario() {
		Scanner sc = new Scanner(System.in);
		
		Funcionario funcionario = new Funcionario();
		
		System.out.print("\nDigite o nome do funcionario: ");
		funcionario.setNome(sc.nextLine());
		
		System.out.print("\nDigite o CPF do funcionario: ");
		funcionario.setCpf(sc.nextLine());
		
		System.out.print("\nDigite o cargo do funcionario: ");
		funcionario.setCargo(sc.nextLine());
		
		System.out.print("\nDigite o turno de trabalho: ");
		funcionario.setTurnoDeTrabalho(sc.nextLine());
		
		this.listaFuncionarios.add(funcionario);
		
		System.out.println("\nFuncioario " + funcionario.getNome() + ", cadastrado com Sucesso!\n");
	}
	
	public void editarfuncionario(String cpf) {
		Boolean achou = false;
		Scanner sc = new Scanner(System.in);
		
		// Encontrar Funcionario
		for (Funcionario f : listaFuncionarios) {								
			if (f.getCpf().equalsIgnoreCase(cpf)) { // Encontrou
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
	}
	
	public void cadastrarHoras(String cpf) {
		Scanner sc = new Scanner(System.in);
		Boolean achouFunc = false;

		for (Funcionario f : listaFuncionarios) {
			if (f.getCpf().equalsIgnoreCase(cpf)) {
				achouFunc = true;
				
				System.out.print("\nDigite a quantidade de horas trabalhadas: ");
				Integer horasTrabalhadas = sc.nextInt();
				sc.nextLine();
				
				if (horasTrabalhadas <= 0) {
					System.out.println("\nErro! Digite um valor positivo!\n");
					return;
				}
				
				f.setQtdeHorasTrabalhadas(horasTrabalhadas);
				break;
			}
		}
		
		if (!achouFunc) {
			System.out.println("\nCPF nao encontrado...\n");
		}
	}

	public void calcularSalario(String cpf) {
		Scanner sc = new Scanner(System.in);
		Boolean achou = false;

		for (Funcionario f : listaFuncionarios) {
			if (f.getCpf().equalsIgnoreCase(cpf)) {
				achou = true;
				
				System.out.print("\nDigite o valor da sua hora: ");
				Double valorHora = sc.nextDouble();
				sc.nextLine();
				if (valorHora > 0) {
					f.setValorHoras(valorHora);
					
					System.out.println(f.calculaSalario());	
				} else {
					System.out.print("\nDigite um valor maior que zero!");
				}
				break;
			}
		}
		
		if (!achou) {
			System.out.println("\nCPF nao encontrado...\n");
		}
	}
	
	@Override
	public void listar() {
		for (Funcionario f : listaFuncionarios) {
			System.out.println(f);
		}
	}
	
	@Override
	public void adicionar(Object f) {
		this.listaFuncionarios.add((Funcionario) f);
	}
	
	@Override
	public void remover(Object f) {
		this.listaFuncionarios.remove((Funcionario) f);
	}
}