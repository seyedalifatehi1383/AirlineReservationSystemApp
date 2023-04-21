// این کلاس برای متدی طراحی شده که کارش اینه که حروف کوچک انگلیسی موجود در رشته ها را به حروف بزرگ تبدیل می کند.
// دلیل اینکه من برای این متد کلاس طراحی کردم اینه که این متد در چند کلاس کاربرد دارد.
public class MakeCapitalStringMethod {
    public String makeCapitalString (String string) {
        char[] stringCharArray = string.toCharArray();
        int temp = 'a' - 'A';

        for (int i = 0; i < stringCharArray.length; i++) {
            if (stringCharArray[i] >= 'a' && stringCharArray[i] <= 'z') {
                stringCharArray[i] -= temp;
            }
        }

        return String.valueOf(stringCharArray);
    }
}
