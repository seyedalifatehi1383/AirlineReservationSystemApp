import java.util.Objects;

// این کلاس برای متد برابری رشته ها در حالی است که بزرگی و کوچکی حروف انگلیسی برای ما مهم نیست و چون این تابع برام پر کاربرد بود توی یه کلاس نوشتمش.
public class IsEqualNotCaseSensitiveMethod {
    public boolean isEqualNotCaseSensitive(String string1, String string2) {
        int temp = 'a' - 'A';
        char[] string1CharArray = string1.toCharArray();
        char[] string2CharArray = string2.toCharArray();

        for (int i = 0; i < string1.length(); i++) {
            if (string1CharArray[i] >= 'A' && string1CharArray[i] <= 'Z') {
                string1CharArray[i] += temp;
            }
        }
        string1 = String.valueOf(string1CharArray);

        for (int i = 0; i < string2.length(); i++) {
            if (string2CharArray[i] >= 'A' && string2CharArray[i] <= 'Z') {
                string2CharArray[i] += temp;
            }
        }
        string2 = String.valueOf(string2CharArray);

        return Objects.equals(string1, string2);
    }
}
