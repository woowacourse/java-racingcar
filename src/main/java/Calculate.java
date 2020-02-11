import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_INPUT_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT = 2;

    public static int plus(String input) {

        String[] values;

        Matcher m = Pattern.compile(CUSTOM_INPUT_REGEX)
                .matcher(input);

        if (isCustom(m)) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            input = m.group(CUSTOM_INPUT);
            values = input.split(customDelimiter);
            return add(values);
        }
        values = input.split(DELIMITER);
        return add(values);
    }

    private static int add(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    private static boolean isCustom(Matcher input) {
        return input.find();
    }


}
