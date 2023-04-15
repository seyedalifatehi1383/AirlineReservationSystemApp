// این کلاس برای مدیریت بلیت های رزرو شده مسافران طراحی شده است
public class Tickets {
    private int ticketId;
    private Flights flightInfo;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketID) {
        this.ticketId = ticketID;
    }

    public Flights getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Flights flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Tickets(int ticketID, Flights flightInfo) {
        this.ticketId = ticketID;
        this.flightInfo = flightInfo;
    }
}
