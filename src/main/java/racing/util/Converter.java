package racing.util;

public class Converter {
    public static String[] splitInput(String input) {
        return input.split(",");
    }

    public static int convertType(String input) {
        return Integer.parseInt(input);
    }
}
