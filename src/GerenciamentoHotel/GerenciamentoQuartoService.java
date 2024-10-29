package GerenciamentoHotel;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoQuartoService {
    private List<Quarto> quartos = new ArrayList<>();

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public List<Quarto> listarQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.getStatus().equals("disponível")) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    public void atualizarStatusQuarto(int numero, String novoStatus) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quarto.setStatus(novoStatus);
                System.out.println("Status do quarto atualizado para: " + novoStatus);
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }
}
