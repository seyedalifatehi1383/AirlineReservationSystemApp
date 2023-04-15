import java.util.ArrayList;
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

//    این متد برای قسمت جستجوی پروازها در منوی مسافران می باشد.

}
