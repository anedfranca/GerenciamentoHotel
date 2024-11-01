package GerenciamentoHotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoQuartoService implements gerenciar {
    private List<Quarto> quartos = new ArrayList<>();

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public List<Quarto> listarQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.getStatus().equals("disponível")) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }
    
    public void listarQuartos() {
        for (Quarto quarto : quartos) {
            if (quarto.getStatus().equals("disponível")) {
            	System.out.println(quarto);
            }
        }
    }
    
    public Quarto buscarQuarto(Integer numero) {
        
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        
        return null;
    }

    public void atualizarStatusQuarto(int numero, String novoStatus) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quarto.setStatus(novoStatus);
                System.out.println("Status do quarto atualizado para: " + novoStatus);
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    static int lerInteiroPositivo(String mensagem, Scanner sc) {
        int valor = 0;
        do {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();
            
            if (entrada.isEmpty()) {
                System.out.println("Entrada vazia. Por favor, insira um número inteiro positivo.");
                continue;
            }

            try {
                valor = Integer.parseInt(entrada);
                if (valor <= 0) {
                    System.out.println("Entrada inválida. O número deve ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        } while (valor <= 0);
        return valor;
    }

    static double lerDoublePositivo(String mensagem, Scanner sc) {
        double valor = 0;
        do {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Entrada vazia. Por favor, insira um número decimal positivo.");
                continue;
            }

            try {
                valor = Double.parseDouble(entrada);
                if (valor <= 0) {
                    System.out.println("Entrada inválida. O número deve ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal.");
            }
        } while (valor <= 0);
        return valor;
    }

    static String lerTipoQuarto(String mensagem, Scanner sc) {
        String tipo;
        do {
            System.out.print(mensagem);
            tipo = sc.nextLine().toLowerCase().trim();
            if (tipo.isEmpty()) {
                System.out.println("Entrada vazia. Digite um dos tipos válidos: solteiro, casal, reservado ou suíte.");
                continue;
            }
            if (!(tipo.equals("solteiro") || tipo.equals("casal") || tipo.equals("suíte") || tipo.equals("reservado"))) {
                System.out.println("Entrada inválida. Digite um dos tipos válidos: solteiro, casal, reservado ou suíte.");
            }
        } while (!(tipo.equals("solteiro") || tipo.equals("casal") || tipo.equals("suíte")));
        return tipo;
    }

    static String lerStatusQuarto(String mensagem, Scanner sc) {
        String status;
        do {
            System.out.print(mensagem);
            status = sc.nextLine().toLowerCase().trim();
            if (status.isEmpty()) {
                System.out.println("Entrada vazia. Digite um dos status válidos: disponível, ocupado ou em manutenção.");
                continue;
            }
            if (!(status.equals("disponível") || status.equals("ocupado") || status.equals("em manutenção") || status.equals("reservado"))) {
                System.out.println("Entrada inválida. Digite um dos status válidos: disponível, ocupado ou em manutenção.");
            }
        } while (!(status.equals("disponível") || status.equals("ocupado") || status.equals("em manutenção") || status.equals("reservado") ));
        return status;
    }
    
	@Override
	public void listar() {
		for (Quarto q : quartos) {
			System.out.println(q);
		}
	}
	
	@Override
	public void adicionar(Object q) {
		this.quartos.add((Quarto) q);
	}
	
	@Override
	public void remover(Object q) {
		this.quartos.remove((Quarto) q);
	}
}
