import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// این کلاس برای متد های منوی ادمین طراحی شده است
public class AdminMenuMethods {
    IsEqualNotCaseSensitiveMethod isEqualNotCaseSensitiveMethod = new IsEqualNotCaseSensitiveMethod();
    Scanner input = new Scanner(System.in);

//    این متد برای قسمت اول منوی ادمین (اضافه کردن پرواز ها) زراحی شده است.
    public void addFlights (ArrayList<Flights> flightsArrayList) {
        addFlightMenuLoop: while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                          Add Flights                         ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.print("Please enter the flightId : ");
            String flightId = input.nextLine();
            for (Flights flights : flightsArrayList) {
                if (Objects.equals(flightId, flights.getFlightId())) {
                    System.out.println("\nThis flightId already exists. Please enter another flightID!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue addFlightMenuLoop;
                }
            }

            System.out.print("Please enter the origin : ");
            String origin = input.nextLine();
            System.out.print("Please enter the destination : ");
            String destination = input.nextLine();
            if (isEqualNotCaseSensitiveMethod.isEqualNotCaseSensitive(origin, destination)) {
                System.out.println("The origin and the destination are same. Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Please enter the date : ");
            String date = input.nextLine();

            System.out.print("Please enter the time : ");
            String time = input.nextLine();

            System.out.print("Please enter the price : ");
            String price = input.nextLine();
            if (Objects.equals(price, "")) {
                System.out.println("\nYour entered count of seats is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }
            char[] priceCharArray = price.toCharArray();
            for (int i = 0; i < price.length(); i++) {
                if (!(priceCharArray[i] >= '0' && priceCharArray[i] <= '9')) {
                    System.out.println("\nYour entered charge is wrong! Please add flight again!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue addFlightMenuLoop;
                }
            }

            System.out.print("Please enter the count of the seats : ");
            String seats = input.nextLine();
            if (Objects.equals(seats, "")) {
                System.out.println("\nYour entered count of seats is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }
            char[] seatsCharArray = seats.toCharArray();
            for (int i = 0; i < seats.length(); i++) {
                if (!(seatsCharArray[i] >= '0' && seatsCharArray[i] <= '9')) {
                    System.out.println("\nYour entered count of seats is wrong! Please add flight again!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue addFlightMenuLoop;
                }
            }

            Flights flight = new Flights(Integer.parseInt(seats), destination, date, origin, flightId, time, Integer.parseInt(price));
            flightsArrayList.add(flight);
            System.out.println("Flight added!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


}
