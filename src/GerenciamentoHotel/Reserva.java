package GerenciamentoHotel;

import java.time.LocalDate;

public class Reserva {
	private Hospede titular;
	private Quarto quarto;
    private String tipoQuarto;
    private int numeroHospedes;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean ativa;
    

    public Reserva(Hospede titular, Quarto quarto, String tipoQuarto, int numeroHospedes, LocalDate dataEntrada, LocalDate dataSaida) {
        this.titular = titular;
    	this.quarto = quarto;
    	this.tipoQuarto = tipoQuarto;
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

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    @Override
    public String toString() {
        return "Tipo de Quarto: " + tipoQuarto + ", Número de Hóspedes: " + numeroHospedes +
               ", Entrada: " + dataEntrada + ", Saída: " + dataSaida + ", Ativa: " + ativa;
    }
}