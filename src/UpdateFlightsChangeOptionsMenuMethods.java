// ابن کلاس برای متد های منوی بروزرسانی قسمت های مختلف پرواز (updateFlightsChangeOptionsMenu) پدید آمده است.

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UpdateFlightsChangeOptionsMenuMethods {
    Scanner input = new Scanner(System.in);
    CheckingEnteredData checkingEnteredData = new CheckingEnteredData();

    public void updateFlightId (ArrayList<Flights> flightsArrayList, int index) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Please enter the new flightId : ");
        String newFlightId = input.nextLine();
        flightsArrayList.get(index).setFlightId(newFlightId);
        System.out.println("FlightId changed!");
        System.out.println("Press Enter To Return...");
        input.nextLine();
    }


    public void updateOrigin (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the new origin : ");
            System.out.println("NOTE: New origin and destination of the flight cannot be equals.");
            System.out.print(">> ");
            String newOrigin = input.nextLine();

            if (Objects.equals(flightsArrayList.get(index).getDestination(), newOrigin)) {
                System.out.println("New origin and destination cannot be equals. Please enter another new origin.");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setOrigin(newOrigin);
            System.out.println("Origin changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


    public void updateDestination (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the new destination : ");
            System.out.println("NOTE: New destination and origin of the flight cannot be equals.");
            System.out.print(">> ");
            String newDestination = input.nextLine();

            if (Objects.equals(flightsArrayList.get(index).getOrigin(), newDestination)) {
                System.out.println("New destination and origin cannot be equals. Please enter another new destination.");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setOrigin(newDestination);
            System.out.println("Destination changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


    public void updateDate (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the new date : ");
            System.out.println("NOTE: The entered date should be like the example : 1111-11-11 or 1111/11/11 .");
            System.out.print(">> ");
            String newDate = input.nextLine();

            if (!checkingEnteredData.isEnteredDateRight(newDate)) {
                System.out.println("The entered new date is wrong. Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setDate(newDate);
            System.out.println("Date changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


    public void updateTIme (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the new time : ");
            System.out.println("NOTE: The entered time should be like the example : 12:12 .");
            System.out.print(">> ");
            String newTime = input.nextLine();

            if (!checkingEnteredData.isEnteredTimeRight(newTime)) {
                System.out.println("The entered new time is wrong. Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setTime(newTime);
            System.out.println("Time changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


    public void updatePrice (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("Please enter the new price : ");
            String newPrice = input.nextLine();

            if (checkingEnteredData.isEnteredNumberRight(newPrice)) {
                System.out.println("The entered new price is not right. Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setPrice(Integer.parseInt(newPrice));
            System.out.println("Price changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


    public void updateSeats (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("Please enter the new count of seats : ");
            String newSeats = input.nextLine();

            if (checkingEnteredData.isEnteredNumberRight(newSeats)) {
                System.out.println("The entered new count of seats is not right. Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            flightsArrayList.get(index).setSeats(Integer.parseInt(newSeats));
            System.out.println("Seats changed!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }
}
