import java.util.ArrayList;

/**
 * Advanced Programming
 * @Teacher Dr.Bostan
 * @author Seyed Ali Fatehi
 * @deprecated Second Project (HW2) :
 * Airline Reservation System
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Flights> flightsArrayList = new ArrayList<>();
        ArrayList<Passengers> passengersArrayList = new ArrayList<>();
        Menus menus = new Menus();

        menus.mainMenu(flightsArrayList, passengersArrayList);
    }
}