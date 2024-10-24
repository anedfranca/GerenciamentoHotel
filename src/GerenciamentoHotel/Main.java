package GerenciamentoHotel;

import java.util.Date;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
			
		Pessoa prefeito = new Pessoa();
		
		prefeito.setNome("Beto Lelis");
		
		System.out.println(prefeito.getNome());
		
		Hospede h1 = new Hospede();
		Hospede h2 = new Hospede("Ane dourada", "7878787", new Date(10, 10, 2000), "Irece BA", "83 99999-8765");
		
		
		
		System.out.println(h2);
	}

	

}
