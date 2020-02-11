import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculate {
    private static final String CUSTOM_INPUT_REGEX = "//(.)\n(.*)";

    public static DelimiterAndTale removeHead(String input) {
        Matcher m = Pattern.compile(CUSTOM_INPUT_REGEX)
                .matcher(input);
        if (m.find()) {
            return new DelimiterAndTale(m.group(1), m.group(2));
        }
        return new DelimiterAndTale("[,:]", input);
    }
}
