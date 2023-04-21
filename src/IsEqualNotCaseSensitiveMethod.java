import java.util.Objects;

// این کلاس برای متد برابری رشته ها در حالی است که بزرگی و کوچکی حروف انگلیسی برای ما مهم نیست و چون این تابع برام پر کاربرد بود توی یه کلاس نوشتمش.
public class IsEqualNotCaseSensitiveMethod {
    MakeCapitalStringMethod makeCapitalStringMethod = new MakeCapitalStringMethod();

    public boolean isEqualNotCaseSensitive(String string1, String string2) {
        return (Objects.equals(makeCapitalStringMethod.makeCapitalString(string1), makeCapitalStringMethod.makeCapitalString(string2)));
    }
}
