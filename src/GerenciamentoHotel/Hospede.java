package GerenciamentoHotel;

import java.util.Date;

public class Hospede extends Pessoa {
	private Date dataNasc;
	private String endereco;
	private String numeroContato;
	
	public Hospede() {
		super();
	}
	
	public Hospede(String n, String c, Date d, String e, String nc) {
		super(n, c);
		this.setDataNasc(d);
		this.setEndereco(e);
		this.setNumeroContato(nc);
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
