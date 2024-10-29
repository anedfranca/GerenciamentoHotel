package hotel;

public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private double precoDiaria;
    private boolean disponivel;

    public Quarto(int numero, String tipo, int capacidade, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
        this.disponivel = true; // Inicialmente, o quarto está disponível
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    // Getters e Setters adicionais podem ser adicionados conforme necessário
}

