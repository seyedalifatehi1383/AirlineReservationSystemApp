import java.util.ArrayList;

// این کلاس برای مدیریت کاربران و مسافرانی که ثبتنام کردند طراحی شده است

public class Passengers {
    private String username;
    private String password;
    private long charge;
    private ArrayList<Tickets> tickets;
    public long getCharge() {
        return charge;
    }

    public void setCharge(long charge) {
        this.charge = charge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Passengers(String username, String password, long charge) {
        this.username = username;
        this.password = password;
        this.charge = charge;
    }
}
