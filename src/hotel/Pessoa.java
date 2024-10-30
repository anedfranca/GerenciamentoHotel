package hotel;

import java.util.Scanner;

public class Pessoa {
	private String nome;
	private String cpf;
	
	public Pessoa() {
		// 
	}
	
	public Pessoa(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}		

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
	    char[] digitosInvalidos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	    while (true) {
	        boolean temDigitoInvalido = false;

	        for (char digito : digitosInvalidos) {
	            if (nome.indexOf(digito) != -1) {
	                temDigitoInvalido = true;
	                break;
	            }
	        }

	        if (temDigitoInvalido) {
	            System.out.println("\nNome inválido, ele não pode conter números!");
	            System.out.print("Digite novamente: ");
	            Scanner sc = new Scanner(System.in);
	            nome = sc.nextLine();
	        } else {
	            break;
	        }
	    }

	    nome = trataEntrada(nome);
	    this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}
	
	private static boolean isNotEmptyOrBlankOrNull(String valor) {
		if (valor.isEmpty() || valor.isBlank() || valor == null) {
			return false;
		}
		return true;
	}
	
	protected static String trataEntrada(String entrada) {
		while (true) {
			if (isNotEmptyOrBlankOrNull(entrada)) {
				return entrada;
			}
			
			System.out.println("\nEntrada inválida!!");
			System.out.print("Digite um novo valor: ");
			Scanner sc = new Scanner(System.in);
			entrada = sc.nextLine();
		}
	}
	
	private static boolean isCpfValid(String cpf) {
	    cpf = cpf.replaceAll("\\D", "");

	    if (cpf.length() != 11) {
	        return false;
	    }

	    if (cpf.chars().distinct().count() == 1) {
	        return false;
	    }

	    int soma = 0;
	    for (int i = 0; i < 9; i++) {
	        soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	    }
	    int primeiroDigito = (soma * 10) % 11;
	    if (primeiroDigito == 10) {
	        primeiroDigito = 0;
	    }
	    if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
	        return false;
	    }

	    soma = 0;
	    for (int i = 0; i < 10; i++) {
	        soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	    }
	    int segundoDigito = (soma * 10) % 11;
	    if (segundoDigito == 10) {
	        segundoDigito = 0;
	    }
	    return segundoDigito == Character.getNumericValue(cpf.charAt(10));
	}

	public void setCpf(String cpf) {
		while (true) {
			try {
				if (isCpfValid(cpf)) {
					this.cpf = cpf;		
					return;
				} else {
					throw new IllegalArgumentException("CPF inválido");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nCPF inválido!");
				System.out.print("Digite um novo CPF: ");
				Scanner sc = new Scanner(System.in);
				cpf = sc.nextLine();
			}
			
		}
	}
	
}