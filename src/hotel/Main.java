package hotel;

import hotel.GerenciamentoReservas;
import hotel.Reserva;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GerenciamentoQuartoService gerenciamentoQuartos = new GerenciamentoQuartoService();
        GerenciadorHospedesService gerenciadorHospedesService = new GerenciadorHospedesService();
        GerenciadorFuncionariosService gerenciadorFuncionariosService = new GerenciadorFuncionariosService();
        GerenciamentoReservas gerenciamentoReservas = new GerenciamentoReservas();

        Scanner sc = new Scanner(System.in);
        int op1, op2;

        while (true) {
            System.out.println("\n1. Quartos");
            System.out.println("2. Hospedes");
            System.out.println("3. Reservas");
            System.out.println("4. Funcionarios");
            System.out.println("5. Check-in/Check-out");
            System.out.println("6. Sair\n");

            System.out.print("Digite a opcao desejada: ");
            op1 = sc.nextInt();

            switch (op1) {
                case 1:
                    // Lógica para quartos
                    break;

                case 2:
                    // Lógica para hóspedes
                    break;

                case 3: // Reservas
                    System.out.println("\n1. Adicionar Reserva");
                    System.out.println("2. Cancelar Reserva");
                    System.out.println("3. Verificar Disponibilidade");
                    System.out.println("4. Listar Reservas");
                    System.out.println("5. Voltar");

                    System.out.print("Digite a opcao desejada: ");
                    op2 = sc.nextInt();

                    switch (op2) {
                        case 1: // Adicionar Reserva
                            sc.nextLine();
                            System.out.print("Digite o tipo do quarto: ");
                            String tipoQuarto = sc.nextLine();
                            System.out.print("Digite o número de hóspedes: ");
                            int numeroHospedes = sc.nextInt();
                            System.out.print("Digite a data de entrada (AAAA-MM-DD): ");
                            LocalDate dataEntrada = LocalDate.parse(sc.next());
                            System.out.print("Digite a data de saída (AAAA-MM-DD): ");
                            LocalDate dataSaida = LocalDate.parse(sc.next());

                            gerenciamentoReservas.adicionarReserva(tipoQuarto, numeroHospedes, dataEntrada, dataSaida);
                            break;

                        case 2: // Cancelar Reserva
                            System.out.print("Digite o índice da reserva para cancelar: ");
                            int indiceReserva = sc.nextInt();
                            gerenciamentoReservas.cancelarReserva(indiceReserva);
                            break;

                        case 3: // Verificar Disponibilidade
                            sc.nextLine();
                            System.out.print("Digite o tipo do quarto: ");
                            String tipoQuartoVerificar = sc.nextLine();
                            System.out.print("Digite a data de entrada (AAAA-MM-DD): ");
                            LocalDate dataEntradaVerificar = LocalDate.parse(sc.next());
                            System.out.print("Digite a data de saída (AAAA-MM-DD): ");
                            LocalDate dataSaidaVerificar = LocalDate.parse(sc.next());

                            gerenciamentoReservas.verificarDisponibilidade(tipoQuartoVerificar, dataEntradaVerificar, dataSaidaVerificar);
                            break;

                        case 4: // Listar Reservas
                            gerenciamentoReservas.listarReservas();
                            break;

                        case 5: // Voltar
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                case 4:
                    // Lógica para funcionários
                    break;

                case 5:
                    // Lógica para Check-in/Check-out
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
