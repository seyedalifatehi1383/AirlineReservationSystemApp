// این کلاس برای مدیریت بلیت های رزرو شده مسافران طراحی شده است
public class Tickets {
    private String ticketId;
    private Flights flightInfo;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Flights getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Flights flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Tickets(String ticketId, Flights flightInfo) {
        this.ticketId = ticketId;
        this.flightInfo = flightInfo;
    }
}
