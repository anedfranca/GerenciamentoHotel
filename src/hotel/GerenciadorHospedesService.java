package hotel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class GerenciadorHospedesService {
	
	private ArrayList<Hospede> listaHospedes;
	
	public GerenciadorHospedesService() {
		listaHospedes = new ArrayList<>();
	}
	
	public void addHospede(Hospede h) {
		this.listaHospedes.add(h);
	}
	
	public void cadastrarHospede() {
		Scanner sc = new Scanner(System.in);
		
		Hospede hospede = new Hospede();
		
		System.out.print("\nDigite o nome do hospede: ");
		hospede.setNome(sc.nextLine());
		
		System.out.print("\nDigite o CPF do hospede: ");
		hospede.setCpf(sc.nextLine());	

		System.out.print("\nDigite a data de nascimento do hospede: ");
		hospede.setDataNasc(sc.nextLine());
		
		System.out.print("\nDigite o endereco do hospede: ");
		hospede.setEndereco(sc.nextLine());
		
		System.out.print("\nDigite o telefone de contato do hospede: ");
		hospede.setNumeroContato(sc.nextLine());
		
		this.addHospede(hospede);
		
		System.out.println("\nHospede Cadastrado com Sucesso!\n");
	}
	
	public void editarHospede(String cpf) {
		Boolean achou = false;
		Scanner sc = new Scanner(System.in);
		
		// Encontrar Hospede
		for (Hospede h : this.listaHospedes) {								
			if (h.getCpf().equalsIgnoreCase(cpf)) { // Encontrou
				achou = true;
				
				System.out.println("Hospede " + h.getNome() + ", encontrado com sucesso!");
				
				System.out.print("\nDigite o nome corrigido do hospede: ");
				String nomeNovo = sc.nextLine();
				
				h.setNome(nomeNovo);

				System.out.print("\nDigite a data de nascimento corrigida do hospede: ");
				h.setDataNasc(sc.nextLine());
				
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
	}
	
	
	
}