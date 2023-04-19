import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

// این کلاس برای متد های منوی ادمین طراحی شده است
public class AdminMenuMethods {
    CheckingEnteredData checkingEnteredData = new CheckingEnteredData();
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
                    System.out.println("\nThis flightId already exists. Please enter another flightId!");
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

            if (!checkingEnteredData.isEnteredDateRight(date)) {
                System.out.println("\nYour entered date is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Please enter the time : ");
            String time = input.nextLine();

            if (!checkingEnteredData.isEnteredTimeRight(time)) {
                System.out.println("\nYour entered time is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Please enter the price : ");
            String price = input.nextLine();

            if (!checkingEnteredData.isEnteredNumberRight(price)) {
                System.out.println("\nYour entered price is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            System.out.print("Please enter the count of the seats : ");
            String seats = input.nextLine();

            if (!checkingEnteredData.isEnteredNumberRight(seats)) {
                System.out.println("\nYour entered count of seats is wrong! Please add flight again!");
                System.out.println("Press Enter To Continue...");
                input.nextLine();
                continue;
            }

            Flights flight = new Flights(Integer.parseInt(seats), destination, date, origin, flightId, time, Integer.parseInt(price));
            flightsArrayList.add(flight);
            System.out.println("Flight added!");
            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }

//    این متد برای تغییر دادن اطلاعات پرواز(ها) در منوی ادمین می باشد.
//    به ظاهر در این متد، ایدی پروازی که ادمین وارد می کند بررسی می شود و اگر این ایدی درست بود به متد پایینی منتقل می شود
//    ولی چون مدیریت قسمت بروزرسانی اطلاعات پرواز در این متد صورت می گیرد و متد پایینی هم زیرمجموعه این متد هست،
//    من این متد را متد اصلی برای قسمت بروزرسانی اطلاعات پرواز در نظر گرفتم.
    public void updateFlights (ArrayList<Flights> flightsArrayList) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                        Update Flights                        ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            if (flightsArrayList.isEmpty()) {
                System.out.println("There is no added flights!");
                System.out.println("Press Enter To Return...");
                input.nextLine();
                return ;
            }

            else {
                System.out.println("Please enter the flightId : ");
                System.out.println("NOTE: If you want to return to the previous page, please type \"return\" then press enter.");
                System.out.print(">> ");
                String flightId = input.nextLine();

                if (Objects.equals(flightId, "return")) {
                    return ;
                }

                boolean flag = false;
                int index = 0;
                for (int i = 0; i < flightsArrayList.size(); i++) {
                    if (Objects.equals(flightId, flightsArrayList.get(i).getFlightId())) {
                        flag = true;
                        index = i;
                    }
                }

                if (!flag) {
                    System.out.println("This flightId not exists! Please enter another flightID!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                }

                else {
                    updateFlightsChangeOptionsMenu(flightsArrayList, index);
                }
            }
        }
    }

//    این متد برای منوی انتخاب و تغییر اطلاعات پرواز است.
    public void updateFlightsChangeOptionsMenu (ArrayList<Flights> flightsArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                        Update Flights                        ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Please choose that which of the following chooses you want to update :\n");
            System.out.println("    1- FlightId");
            System.out.println("    2- Origin");
            System.out.println("    3- Destination");
            System.out.println("    4- Date");
            System.out.println("    5- Price");
            System.out.println("    6- Seats");
            System.out.println("    7- Time");
            System.out.println("    0- Return");
            System.out.print("\n>> ");
            String select = input.nextLine();

            switch (select) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.print("Please enter the new flightId : ");
                    String newFlightId = input.nextLine();
                    flightsArrayList.get(index).setFlightId(newFlightId);
                    System.out.println("FlightId changed!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    return ;

                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.print("Please enter the new origin : ");
                    String newOrigin = input.nextLine();
                    flightsArrayList.get(index).setOrigin(newOrigin);
                    System.out.println("Origin changed!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    return ;

                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.print("Please enter the new destination : ");
                    String newDestination = input.nextLine();
                    flightsArrayList.get(index).setDestination(newDestination);
                    System.out.println("Destination changed!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    return ;

                case "4":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Please enter the new date : ");
                    System.out.println("NOTE: The entered date should be like the example : 1111-11-11 or 1111/11/11.");
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

                case "5":
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

                case "6":
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

                case "7":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Please enter the new time : ");
                    System.out.println("NOTE: The entered time should be like the example : 12:12.");
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

                case "0":
                    return ;

                default:
                    System.out.println("Please check your command!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    break;
            }
        }
    }

//    این متد برای حذف پروازها می باشد.
    public void removeFlights (ArrayList<Flights> flightsArrayList) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("                         Remove Flights                       ");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            if (flightsArrayList.isEmpty()) {
                System.out.println("There is no added flights!");
            }

            else {
                System.out.println("Please enter the Id of the flight that you want to remove : ");
                System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
                System.out.print(">> ");
                String flightId = input.nextLine();
                if (Objects.equals(flightId, "return")) {
                    return ;
                }

                boolean flag = false;
                for (int i = 0; i < flightsArrayList.size(); i++) {
                    if (Objects.equals(flightId, flightsArrayList.get(i).getFlightId())) {
                        flag = true;
                        flightsArrayList.remove(i);
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("There is no flightIds like this, please try another flightId!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue;
                }

                System.out.println("Flight removed!");
            }

            System.out.println("Press Enter To Return...");
            input.nextLine();
            return ;
        }
    }


// این متد برای نمایش جدول پروازها می باشد.
    public void flightSchedules (ArrayList<Flights> flightsArrayList) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (flightsArrayList.isEmpty()) {
            System.out.println("There is nothing to see!");
        }

        else {
            System.out.printf("|%-20s|%-13s|%-13s|%-13s|%-6s|%-13s|%-7s|", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            System.out.println("\n.............................................................................................");
            for (Flights flights : flightsArrayList) {
                System.out.printf(Locale.US, "|%-20s|%-13s|%-13s|%-13s|%-6s|%,-13d|%-7d|", flights.getFlightId(), flights.getOrigin(), flights.getDestination(), flights.getDate(), flights.getTime(), flights.getPrice(), flights.getSeats());
                System.out.println("\n.............................................................................................");
            }
        }

        System.out.println("Press Enter To Return...");
        input.nextLine();
    }
}
