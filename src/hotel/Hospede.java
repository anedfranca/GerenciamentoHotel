package hotel;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Hospede extends Pessoa {
	private LocalDate dataNasc;
	private String endereco;
	private String numeroContato;
	//private ArrayList<reserva> historico = new ArrayList();
	
	public Hospede() {
		super();
	}
	
	public Hospede(String n, String c, String d, String e, String nc) {
		super(n, c);
		this.setDataNasc(d);
		this.setEndereco(e);
		this.setNumeroContato(nc);
	}
	
	@Override
	public String toString() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Data de nascimento: " + this.getDataNasc());
		System.out.println("Numero de contato: " + this.getNumeroContato());
		System.out.println("Endereço: " + this.getEndereco());
		return "";
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
	    // Formato esperado: dd/MM/yyyy
	    Scanner sc = new Scanner(System.in);
	    
	    while (true) {
	        if (dataNasc.length() != 10 || dataNasc.charAt(2) != '/' || dataNasc.charAt(5) != '/') {
	            System.out.println("\nData inválida, formato correto: dd/MM/yyyy");
	            System.out.print("Digite novamente: ");
	            dataNasc = sc.nextLine();
	            continue;
	        }

	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            LocalDate data = LocalDate.parse(dataNasc, formatter);
	            this.dataNasc = data;
	            return;
	        } catch (DateTimeParseException e) {
	            System.out.println("\nData inválida, por favor insira uma data real.");
	            System.out.print("Digite novamente: ");
	            dataNasc = sc.nextLine();
	        }
	    }
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		endereco = trataEntrada(endereco);
		this.endereco = endereco;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		numeroContato = trataEntrada(numeroContato);
		this.numeroContato = numeroContato;
	}
	
	

}