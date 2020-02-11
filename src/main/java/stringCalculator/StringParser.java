package stringCalculator;

public class StringParser {
    public static String[] parse(String input) {
        return input.split(",|:");
    }
}