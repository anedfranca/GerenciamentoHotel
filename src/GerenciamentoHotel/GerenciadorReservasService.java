package GerenciamentoHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorReservasService {
    private List<Reserva> reservas;

    public GerenciadorReservasService() {
        this.reservas = new ArrayList<>();
    }

//    public void adicionarReserva(String tipoQuarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
//        reservas.add(new Reserva(tipoQuarto, numeroHospedes, dataEntrada, dataSaida));
//        System.out.println("Reserva adicionada com sucesso!");
//    }

    public void cancelarReserva(int indice) {
        if (indice >= 0 && indice < reservas.size() && reservas.get(indice).isAtiva()) {
            reservas.get(indice).cancelar();
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("Reserva inválida ou já cancelada.");
        }
    }

    public void verificarDisponibilidade(String tipoQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        boolean disponivel = reservas.stream()
                .filter(r -> r.getTipoQuarto().equals(tipoQuarto) && r.isAtiva())
                .allMatch(r -> r.verificaDisponibilidade(dataEntrada, dataSaida));

        if (disponivel) {
            System.out.println("Quarto disponível para o tipo: " + tipoQuarto);
        } else {
            System.out.println("Não há disponibilidade para o tipo de quarto: " + tipoQuarto + " nas datas selecionadas.");
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
} 