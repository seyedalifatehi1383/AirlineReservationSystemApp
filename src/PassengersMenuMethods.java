import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

// این کلاس برای توابع منو مسافران ایجاد شده است.
public class PassengersMenuMethods {
    Scanner input = new Scanner(System.in);
    CheckingEnteredData checkingEnteredData = new CheckingEnteredData();
    IsEqualNotCaseSensitiveMethod isEqualNotCaseSensitiveMethod = new IsEqualNotCaseSensitiveMethod();

//    این متد برای قسمت تغییر رمز عبور منوی مسافران طراحی شده است
    public void changePassword (ArrayList<Passengers> passengersArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                        Change Password                        ");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Please enter your previous password : ");
            System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
            System.out.print(">> ");
            String previousPassword = input.nextLine();
            if (Objects.equals(previousPassword, "return")) {
                return ;
            }

            if (!Objects.equals(previousPassword, passengersArrayList.get(index).getPassword())) {
                System.out.println("\nThe entered password is wrong! Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Please enter your new password : ");
            String newPassword = input.nextLine();
            System.out.print("Please confirm your new password : ");
            String confirmNewPassword = input.nextLine();
            if (!Objects.equals(newPassword, confirmNewPassword)) {
                System.out.println("\nYou didn't confirm your password. Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
            }

            else {
                if (Objects.equals(passengersArrayList.get(index).getPassword(), newPassword)) {
                    System.out.println("\nThis is your previous password. Please try another password!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                }

                else {
                    passengersArrayList.get(index).setPassword(newPassword);
                    System.out.println("\nPassword changed!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    break;
                }
            }
        }
    }

//    این متد برای قسمت جستجوی بلیت ها در منوی مسافران می باشد.
    public void searchFlightTickets (ArrayList<Flights> flightsArrayList) {

        while (true) {
            FindFlights findFlights = new FindFlights();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                          Search Flight Tickets                         ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

            if (flightsArrayList.isEmpty()) {
                System.out.println("There is no flight added!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            ArrayList<Flights> foundFlightsArrayList = new ArrayList<>(flightsArrayList);

            System.out.println("Please enter the wanted filters : ");
            System.out.println("NOTE: If any filter is not important for you, you can type \"ni\" as the wanted filter.");
            System.out.println("NOTE: If you want to return to the passengers menu, you can type \"return\" as the origin then press enter.");
            System.out.print("Origin : ");
            String origin = input.nextLine();

            if (Objects.equals(origin, "return")) {
                return ;
            }

            System.out.print("Destination : ");
            String destination = input.nextLine();

            if (isEqualNotCaseSensitiveMethod.isEqualNotCaseSensitive(origin, destination) && !origin.equals("ni")) {
                System.out.println("Origin and destination cannot be equals. Please search again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Date : ");
            String date = input.nextLine();

            System.out.print("Time : ");
            String time = input.nextLine();

            System.out.print("Minimum price : ");
            String minPrice = input.nextLine();
            if (!Objects.equals(minPrice, "ni")) {
                if (!(checkingEnteredData.isEnteredNumberRight(minPrice))) {
                    System.out.println("The entered minimum price is not correct! Please search again!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue;
                }
            }

            else {
                minPrice = "0";
            }

            System.out.print("Maximum price : ");
            String maxPrice = input.nextLine();
            if (!Objects.equals(maxPrice, "ni")) {
                if (!(checkingEnteredData.isEnteredNumberRight(maxPrice))) {
                    System.out.println("The entered maximum price is not correct! Please search again!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue;
                }
            }

            else {
                int maxPriceNumber = flightsArrayList.get(0).getPrice();
                for (int i = 1; i < flightsArrayList.size(); i++) {
                    if (maxPriceNumber < flightsArrayList.get(i).getPrice()) {
                        maxPriceNumber = flightsArrayList.get(i).getPrice();
                    }
                }
                maxPrice = String.valueOf(maxPriceNumber);
            }

            if (!Objects.equals(origin, "ni")) {
                findFlights.findOrigin(foundFlightsArrayList, origin);
            }

            if (!Objects.equals(origin, "ni") && foundFlightsArrayList.isEmpty()) {
                System.out.println("No flights were found based on your filters!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            if (!Objects.equals(destination, "ni")) {
                findFlights.findDestination(foundFlightsArrayList, destination);
            }

            if (!Objects.equals(destination, "ni") && foundFlightsArrayList.isEmpty()) {
                System.out.println("No flights were found based on your filters!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            if (!Objects.equals(date, "ni")) {
                findFlights.findDate(foundFlightsArrayList, date);
            }

            if (!Objects.equals(date, "ni") && foundFlightsArrayList.isEmpty()) {
                System.out.println("No flights were found based on your filters!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            if (!Objects.equals(time, "ni")) {
                findFlights.findTime(foundFlightsArrayList, date);
            }

            if (!Objects.equals(time, "ni") && foundFlightsArrayList.isEmpty()) {
                System.out.println("No flights were found based on your filters!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            findFlights.findPrice(foundFlightsArrayList, Integer.parseInt(minPrice), Integer.parseInt(maxPrice));
            if (foundFlightsArrayList.isEmpty()) {
                System.out.println("No flights were found based on your filters!");
            }

            else {
                System.out.println("The info(s) of the flight(s) you are looking for is(are) :");
                System.out.printf("|%-15s|%-13s|%-13s|%-12s|%-8s|%-13s|%-7s|", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
                System.out.println("\n..........................................................................................................................");
                for (Flights flights : foundFlightsArrayList) {
                    System.out.printf(Locale.US, "|%-15s|%-13s|%-13s|%-12s|%-8s|%-13d|%-7d|", flights.getFlightId(), flights.getOrigin(), flights.getDestination(), flights.getDate(), flights.getTime(), flights.getPrice(), flights.getSeats());
                    System.out.println("\n..........................................................................................................................");
                }
            }
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


//    این متد برای رزرو کردن بلیت می باشد.
    public void bookingTicket (ArrayList<Flights> flightsArrayList, ArrayList<Passengers> passengersArrayList, ArrayList<Tickets> ticketsArrayList, int passengerIndex) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                          Booking Tickets                         ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

            if (flightsArrayList.isEmpty()) {
                System.out.println("There is no flights for booking!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            System.out.println("Please enter the fightId : ");
            System.out.println("NOTE : If you want to return to the previous page, you can type \"return\" then press enter.");
            System.out.print(  ">> "  );
            String flightId = input.nextLine();

            if (Objects.equals(flightId, "return")) {
                return ;
            }

            boolean flag = false;
            int flightIndex = 0;
            for (int i = 0; i < flightsArrayList.size(); i++) {
                if (Objects.equals(flightId, flightsArrayList.get(i).getFlightId())) {
                    flag = true;
                    flightIndex = i;
                    break;
                }
            }

            if (!flag) {
                System.out.println("This flightId not exists. Please try another flightID.");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            if (flightsArrayList.get(flightIndex).getSeats() == 0) {
                System.out.println("There is no seats remained for this flight.");
                System.out.println("Press Enter To Continue...");
                input.nextLine();

            } else if (passengersArrayList.get(passengerIndex).getCharge() < flightsArrayList.get(flightIndex).getPrice()) {
                System.out.println("Your charge is not enough to book this ticket. Please charge your account then try again.");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            else {
//                اینجا من اومدم تیکت ایدی رو اینجوری ساختم که اول یوزرنیم کاربر بعد ایدی پرواز ، بعد تعداد صندلی های باقی مونده قبل اینکه کاربر بلیت رزرو کنه و در نهایت تعداد دفعات کنسل کردن بلیت و هر کدوم با @ از هم جدا شدن مثال : username@flightId@434@0)
//                درباره تعداد دفعات کنسلی بلیت در کلاس مسافران بالای این ویژگی توضیحاتی داده شده است.
                String ticketId = "";
                ticketId = ticketId.concat(passengersArrayList.get(passengerIndex).getUsername());
                ticketId = ticketId.concat("@");
                ticketId = ticketId.concat(flightsArrayList.get(flightIndex).getFlightId());
                ticketId = ticketId.concat("@");
                ticketId = ticketId.concat(String.valueOf(flightsArrayList.get(flightIndex).getSeats()));
                ticketId = ticketId.concat("@");
                ticketId = ticketId.concat(String.valueOf(passengersArrayList.get(passengerIndex).getCountCancelledTickets()));

                int countSeats = flightsArrayList.get(flightIndex).getSeats();
                countSeats--;

                long chargeAmount = passengersArrayList.get(passengerIndex).getCharge();
                chargeAmount -= flightsArrayList.get(flightIndex).getPrice();
                passengersArrayList.get(passengerIndex).setCharge(chargeAmount);
                flightsArrayList.get(flightIndex).setSeats(countSeats);

                Tickets ticket = new Tickets(ticketId, flightsArrayList.get(flightIndex));
                ticketsArrayList.add(ticket);

                System.out.println("Ticket booked.");
                System.out.println("Your ticketId is : " + ticketId);
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }
        }
    }


//    این متد برای نمایش بلیت های رزرو شده می باشد.
    public void bookedTickets (ArrayList<Tickets> ticketsArrayList) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("                                         Booked Tickets                                      ");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

        if (ticketsArrayList.isEmpty()) {
            System.out.println("There is nothing to see!");
        }

        else {
            System.out.printf("|%-25s|%-15s|%-13s|%-13s|%-12s|%-8s|%-15s|", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time", "Amount Paid");
            System.out.println("\n.......................................................................................................................");
            for (Tickets tickets : ticketsArrayList) {
                System.out.printf(Locale.US, "|%-25s|%-15s|%-13s|%-13s|%-12s|%-8s|%-,15d|", tickets.getTicketId(), tickets.getFlightInfo().getFlightId(), tickets.getFlightInfo().getOrigin(), tickets.getFlightInfo().getDestination(), tickets.getFlightInfo().getDate(), tickets.getFlightInfo().getTime(), tickets.getFlightInfo().getPrice());
                System.out.println("\n.......................................................................................................................");
            }
        }

        System.out.println("Press Enter To Return...");
        input.nextLine();
    }


//    این متد برای اینه که مسافر یتونه حسابشو شارژ کنه.
    public void addCharge (ArrayList<Passengers> passengersArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                              Add Charge                             ");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Please enter the amount of charge you want to add to your wallet : ");
            System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
            System.out.print(">> ");
            String charge = input.nextLine();

            if (Objects.equals(charge, "return")) {
                return ;
            }

            if (!(checkingEnteredData.isEnteredNumberRight(charge))) {
                System.out.println("\nYour entered charge is wrong! Please try again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            long passengerCharge = passengersArrayList.get(index).getCharge();
            passengerCharge += Integer.parseInt(charge);
            passengersArrayList.get(index).setCharge(passengerCharge);
            System.out.println("\nCharging done!");
            System.out.println("The amount of your charge is : " + passengerCharge);
            System.out.println("Press Enter To Return...");
            input.nextLine();
            break;
        }
    }


//   این متد برای کنسل کردن بلیت مورد استفاده قرار می گیرد.
    public void ticketCancellation (ArrayList<Passengers> passengersArrayList, ArrayList<Tickets> ticketsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (ticketsArrayList.isEmpty()) {
                System.out.println("There is no booked tickets for cancelling!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                        Ticket Cancellation                        ");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Please enter the ticketId : ");
            System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
            System.out.print(">> ");
            String ticketId = input.nextLine();

            if (Objects.equals(ticketId, "return")) {
                return ;
            }

            for (int i = 0; i < ticketsArrayList.size(); i++) {
                if (ticketId.equals(ticketsArrayList.get(i).getTicketId())) {
                    long passengerCharge = passengersArrayList.get(index).getCharge();
                    passengerCharge += ticketsArrayList.get(i).getFlightInfo().getPrice();
                    passengersArrayList.get(index).setCharge(passengerCharge);

                    int countSeats = ticketsArrayList.get(i).getFlightInfo().getSeats();
                    countSeats++;
                    ticketsArrayList.get(i).getFlightInfo().setSeats(countSeats);

                    int countCancelledSeats = passengersArrayList.get(index).getCountCancelledTickets();
                    countCancelledSeats++;
                    passengersArrayList.get(index).setCountCancelledTickets(countCancelledSeats);

                    ticketsArrayList.remove(i);

                    System.out.println("Ticket canceled!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    return ;
                }
            }

            System.out.println("This ticketId not exists! Please try another ticketId.");
            System.out.println("Press Enter To Continue...");
            input.nextLine();
        }
    }
}