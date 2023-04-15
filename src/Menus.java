import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
    Scanner input = new Scanner(System.in);

    public void mainMenu(ArrayList<Flights> flightsArrayList, ArrayList<Passengers> passengersArrayList) {
        mainMenuLoop: while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("     WELCOME TO AIRLINE RESERVATION SYSTEM     ");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println(" .................MENU OPTIONS................ ");
            System.out.println();
            System.out.println("    <1> Sign in");
            System.out.println("    <2> Sign up");
            System.out.println("    <3> Exit");
            System.out.print(  " >> "  );
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    signInMenu(flightsArrayList, passengersArrayList);
                    break;
                case "2":
                    signUpMenu(passengersArrayList);
                    break;
                case "3":
                    break mainMenuLoop;
                default:
                    System.out.println("Please check your command!");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    break;
            }
        }
    }
}
