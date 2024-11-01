package GerenciamentoHotel;

import java.time.LocalDate;

public class Reserva {
	private Hospede titular;
	private Quarto quarto;
    private int numeroHospedes;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean ativa;
    

    public Hospede getTitular() {
		return titular;
	}

	public void setTitular(Hospede titular) {
		this.titular = titular;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Reserva(Hospede titular, Quarto quarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
        this.titular = titular;
    	this.quarto = quarto;
        this.numeroHospedes = numeroHospedes;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.ativa = true;
    }

    public void cancelar() {
        this.ativa = false;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public boolean verificaDisponibilidade(LocalDate entrada, LocalDate saida) {
        return ativa && (dataSaida.isBefore(entrada) || dataEntrada.isAfter(saida));
    }


    @Override
    public String toString() {
        return "Número de Hóspedes: " + numeroHospedes +
               ", Entrada: " + dataEntrada + ", Saída: " + dataSaida + ", Ativa: " + ativa;
    }
}