package hotel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class HotelService {
    private ArrayList<Hospede> hospedes;
    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;

    public HotelService() {
        hospedes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void realizarCheckIn(Reserva reserva) {
        Quarto quarto = reserva.getQuarto();
        Hospede hospede = reserva.getHospede();

        try {
            if (!quarto.isDisponivel()) {
                throw new IllegalStateException("Erro: O quarto já está ocupado ou em manutenção.");
            }
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado com sucesso para o hóspede: " + hospede.getNome());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void realizarCheckOut(Reserva reserva) {
        Quarto quarto = reserva.getQuarto();
        Hospede hospede = reserva.getHospede();

        try {
            if (quarto.isDisponivel()) {
                throw new IllegalStateException("Erro: O quarto já está desocupado.");
            }

            double totalEstadia = calcularValorEstadia(reserva);
            quarto.setDisponivel(true); // Libera o quarto
            System.out.println("Check-out realizado com sucesso para o hóspede: " + hospede.getNome() +
                               ". Valor total da estadia: R$" + totalEstadia);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private double calcularValorEstadia(Reserva reserva) {
        Date dataCheckIn = reserva.getDataCheckIn();
        Date dataCheckOut = reserva.getDataCheckOut();

        long diffEmMilissegundos = dataCheckOut.getTime() - dataCheckIn.getTime();
        long diasHospedados = TimeUnit.DAYS.convert(diffEmMilissegundos, TimeUnit.MILLISECONDS);
        
        if (diasHospedados == 0) {
            diasHospedados = 1; // Considera-se ao menos uma diária
        }

        return diasHospedados * reserva.getQuarto().getPrecoDiaria();
    }
}
