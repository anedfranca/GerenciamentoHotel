package GerenciamentoHotel;

import java.util.Date;
import java.util.ArrayList;

public class Hospede extends Pessoa {
	private Date dataNasc;
	private String endereco;
	private String numeroContato;
	//private ArrayList<reserva> historico = new ArrayList();
	
	public Hospede() {
		super();
	}
	
	public Hospede(String n, String c, Date d, String e, String nc) {
		super(n, c);
		this.setDataNasc(d);
		this.setEndereco(e);
		this.setNumeroContato(nc);
	}
	
	public String toString() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Data de nascimento: " + this.getDataNasc());
		System.out.println("Numero de contato: " + this.getNumeroContato());
		System.out.println("Endereço: " + this.getEndereco());
		return "";
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}
	
	

}
