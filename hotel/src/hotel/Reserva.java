package hotel;

import java.util.Date;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private Date dataCheckIn;
    private Date dataCheckOut;

    public Reserva(Hospede hospede, Quarto quarto, Date dataCheckIn, Date dataCheckOut) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }
}
