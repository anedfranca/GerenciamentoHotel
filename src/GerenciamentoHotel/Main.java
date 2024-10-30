package GerenciamentoHotel;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static Hospede[] listaHospedes;
	private static int length;

	public static void main(String[] args) {
        
        GerenciamentoQuartoService gerenciamentoQuartos = new GerenciamentoQuartoService();
        Scanner sc = new Scanner(System.in);
        int op1, op2;
        
        while (true) {
            System.out.println("\n1. Quartos");
            System.out.println("2. Hospedes");
            System.out.println("3. Reservas");
            System.out.println("4. Funcionarios");
            System.out.println("5. Check-in/Check-out");
            System.out.println("6. Sair\n");
            
            System.out.print("Digite a opção desejada: ");
            op1 = sc.nextInt();
            sc.nextLine(); 
            
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
                            
                            length = listaHospedes.length;
                            
                            System.out.println("\nHospede Cadastrado com Sucesso!\n");
                        break;
                        
                        case 2:
                            boolean achou = false;
                            
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
                            // Função para histórico de estadias
                        break;
                        
                        case 4:
                            // Voltar para menu principal
                        break;
                    }
                break;
                
                case 3:
                    // Função para Reservas
                break;
                
                case 4:
                    // Função para Funcionarios
                break;
                
                case 5:
                    // Função para Check-in/Check-out
                break;
                
                case 6:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    System.exit(0);
                break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                break;
            }
        }
    }
}
