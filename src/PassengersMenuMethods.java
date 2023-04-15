import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

// این کلاس برای توابع منو مسافران ایجاد شده است.
public class PassengersMenuMethods {
    Scanner input = new Scanner(System.in);

//    این متد برای قسمت تغییر رمز عبور منوی مسافران طراحی شده است
    public void changePassword (ArrayList<Passengers> passengersArrayList, int index) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

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
    public void searchFlightTickets () {

    }


//    این متد برای نمایش بلیت های رزرو شده می باشد.
    public void bookedTickets (ArrayList<Passengers> passengersArrayList, int index) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (passengersArrayList.get(index).getTickets().isEmpty()) {
            System.out.println("There is nothing to see!");
        }

        else {
            System.out.printf("|%-20s|%-15s|%-13s|%-13s|%-12s|%-5s|", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time");
            System.out.println("\n.........................................................................................................................................");
            for (int i = 0; i < passengersArrayList.get(index).getTickets().size(); i++) {
                System.out.printf(Locale.US, "|%-20d|%-15s|%-13s|%-13s|%-12s|%-5s|", passengersArrayList.get(index).getTickets().get(i).getTicketId(), passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getFlightId(), passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getOrigin(), passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getDestination(), passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getDate(), passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getTime());
                System.out.println("\n.........................................................................................................................................");
            }
        }

        System.out.println("Press Enter To Return...");
        input.nextLine();
    }


//    این متد برای اینه که مسافر یتونه حسابشو شارژ کنه.
    public void addCharge (ArrayList<Passengers> passengersArrayList, int index) {
        addChargeMenuLoop: while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the amount of charge you want to add : ");
            System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
            System.out.print(">> ");
            String charge = input.nextLine();
            char[] chargeCharArray = charge.toCharArray();

            if (Objects.equals(charge, "return")) {
                return ;
            }

            for (int i = 0; i < charge.length(); i++) {
                if (!(chargeCharArray[i] >= '0' && chargeCharArray[i] <= '9')) {
                    System.out.println("\nYour entered charge is wrong! Please try again!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue addChargeMenuLoop;
                }
            }

            long passengerCharge;
            passengerCharge = passengersArrayList.get(index).getCharge();
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
    public void ticketCancellation (ArrayList<Passengers> passengersArrayList, int index) {
        ticketCancellationLoop: while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter the ticketId : ");
            System.out.println("NOTE: If you want to return to the passengers menu, please type \"return\" and then press enter.");
            System.out.print(">> ");
            String ticketId = input.nextLine();

            if (Objects.equals(ticketId, "return")) {
                return ;
            }

            char[] ticketIDCharArray = ticketId.toCharArray();
            for (char c : ticketIDCharArray) {
                if (!(c >= '0' && c <= '9')) {
                    System.out.println("The entered ticketId is not valid! Please try again.");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    continue ticketCancellationLoop;
                }
            }

            for (int i = 0; i < passengersArrayList.get(index).getTickets().size(); i++) {
                if (Integer.parseInt(ticketId) == passengersArrayList.get(index).getTickets().get(i).getTicketId()) {
                    passengersArrayList.get(index).getTickets().remove(i);
                    long passengerCharge = passengersArrayList.get(index).getCharge();
                    passengerCharge += passengersArrayList.get(index).getTickets().get(i).getFlightInfo().getPrice();
                    passengersArrayList.get(index).setCharge(passengerCharge);
                    System.out.println("Ticket canceled!");
                    System.out.println("Press Enter To Return...");
                    input.nextLine();
                    return ;
                }
            }

            System.out.println("This ticketId not exists! Please try another ticketID.");
            System.out.println("Press Enter To Continue...");
            input.nextLine();
        }
    }
}
