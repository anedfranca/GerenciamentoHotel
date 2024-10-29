package hotel;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        HotelService hotelService = new HotelService();

        // Criando hóspedes e quartos
        Hospede hospede1 = new Hospede("João Silva", "123.456.789-00", "01/01/1980", "Rua A, 100", "11999999999");
        Quarto quarto1 = new Quarto(101, "Casal", 2, 150.00);

        // Criando uma reserva
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date checkInDate = (Date) dateFormat.parse("10/11/2024");
        Date checkOutDate = (Date) dateFormat.parse("15/11/2024");
        Reserva reserva1 = new Reserva(hospede1, quarto1, checkInDate, checkOutDate);

        // Realizando check-in e check-out
        hotelService.realizarCheckIn(reserva1);
        hotelService.realizarCheckOut(reserva1);
    }
}
