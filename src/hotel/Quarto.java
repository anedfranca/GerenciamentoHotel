package hotel;

public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private double preco;
    private String status;

    public Quarto(int numero, String tipo, int capacidade, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.status = "disponível";
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public int getCapacidade() { return capacidade; }
    public double getPreco() { return preco; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Tipo: " + tipo + ", Capacidade: " + capacidade + ", Preço: " + preco + ", Status: " + status;
    }
}