package util;

public class Converter {
    public static String[] splitInput(String input) {
        String[] names = input.split(",");
        return names;
    }

    public static int convertType(String input) {
        return Integer.parseInt(input);
    }
}
