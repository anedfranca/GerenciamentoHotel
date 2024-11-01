package GerenciamentoHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorReservasService implements gerenciar {
    private List<Reserva> reservas;

    public GerenciadorReservasService() {
        this.reservas = new ArrayList<>();
    }

//    public void adicionarReserva(String tipoQuarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
//        reservas.add(new Reserva(tipoQuarto, numeroHospedes, dataEntrada, dataSaida));
//        System.out.println("Reserva adicionada com sucesso!");
//    }

    public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void cancelarReserva(int indice) {
        if (indice >= 0 && indice < reservas.size() && reservas.get(indice).isAtiva()) {
            reservas.get(indice).cancelar();
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("Reserva inválida ou já cancelada.");
        }
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (int i = 0; i < reservas.size(); i++) {
                System.out.println(i + ": " + reservas.get(i));
            }
        }
    }
    
	public LocalDate recebeData(String dataNasc) {
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
	            return data;
	        } catch (DateTimeParseException e) {
	            System.out.println("\nData inválida, por favor insira uma data real.");
	            System.out.print("Digite novamente: ");
	            dataNasc = sc.nextLine();
	        }
	    }
	}
	
	@Override
	public void listar() {
		for (Reserva r : reservas) {
			System.out.println(r);
		}
	}
	
	@Override
	public void adicionar(Object r) {
		this.reservas.add((Reserva) r);
	}
	
	@Override
	public void remover(Object r) {
		this.reservas.remove((Reserva) r);
	}
}
