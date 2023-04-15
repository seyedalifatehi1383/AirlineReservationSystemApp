import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Flights> flightsArrayList = new ArrayList<>();
        ArrayList<Passengers> passengersArrayList = new ArrayList<>();
        Menus menus = new Menus();

        menus.mainMenu(flightsArrayList, passengersArrayList);
    }
}