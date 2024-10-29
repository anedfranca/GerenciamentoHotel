package hotel;

public class Hospede {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String contato;

    public Hospede(String nome, String cpf, String dataNascimento, String endereco, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }
    
    // Getters e Setters adicionais podem ser adicionados conforme necessário
}

