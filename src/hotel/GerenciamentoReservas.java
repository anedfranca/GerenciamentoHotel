package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoReservas {
    private List<Reserva> reservas;

    public GerenciamentoReservas() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(String tipoQuarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
        reservas.add(new Reserva(tipoQuarto, numeroHospedes, dataEntrada, dataSaida));
        System.out.println("Reserva adicionada com sucesso!");
    }

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
} 
