package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciamentoReservas gerenciamento = new GerenciamentoReservas();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy"); // Formatador de data

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Verificar Disponibilidade");
            System.out.println("4. Listar Reservas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Tipo de Quarto: ");
                    String tipoQuarto = scanner.nextLine();
                    System.out.print("Número de Hóspedes: ");
                    int numeroHospedes = Integer.parseInt(scanner.nextLine());

                    System.out.print("Data de Entrada (ddMMyyyy): ");
                    try {
                        LocalDate dataEntrada = LocalDate.parse(scanner.nextLine(), dateFormatter);

                        System.out.print("Data de Saída (ddMMyyyy): ");
                        LocalDate dataSaida = LocalDate.parse(scanner.nextLine(), dateFormatter);

                        gerenciamento.adicionarReserva(tipoQuarto, numeroHospedes, dataEntrada, dataSaida);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato ddMMyyyy.");
                    }
                    break;
                case 2:
                    System.out.print("Índice da Reserva para Cancelar: ");
                    int indice = Integer.parseInt(scanner.nextLine());
                    gerenciamento.cancelarReserva(indice);
                    break;
                case 3:
                    System.out.print("Tipo de Quarto para Verificar: ");
                    tipoQuarto = scanner.nextLine();
                    System.out.print("Data de Entrada (ddMMyyyy): ");
                    try {
                        LocalDate dataEntrada = LocalDate.parse(scanner.nextLine(), dateFormatter);

                        System.out.print("Data de Saída (ddMMyyyy): ");
                        LocalDate dataSaida = LocalDate.parse(scanner.nextLine(), dateFormatter);

                        gerenciamento.verificarDisponibilidade(tipoQuarto, dataEntrada, dataSaida);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato ddMMyyyy.");
                    }
                    break;
                case 4:
                    gerenciamento.listarReservas();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
