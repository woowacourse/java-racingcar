package stringCalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public static final String COMMEND_END = "\n";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static String regex = "[,:]";
    public static String text = "";

    public int calculateString(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        StringCalculator.text = text;
        return sum(splitText());
    }

    private String[] splitText() {
        if (isCustomDelimiter()) {
            setCustomDelimiter();
        }
        CheckException.checkSplitOk(text, regex);
        return text.split(regex);
    }

    private int sum(String[] values) {
        CheckException.check(values);
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    private boolean isCustomDelimiter() {
        return Pattern.matches(CUSTOM_REGEX, text);
    }

    private void setCustomDelimiter() {
        String[] values = text.split(COMMEND_END);
        addRegex(values[0].substring(2));
        text = values[1];
    }

    private void addRegex(String rg) {
        regex = regex.substring(0, regex.length() - 1);
        regex += rg + "]";
    }
}