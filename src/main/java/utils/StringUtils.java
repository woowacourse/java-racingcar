package utils;

public class StringUtils {

    private static final String SEPARATOR = ",";

    public static String[] splitBySeparator(String inputCarsName) {
        return inputCarsName.split(SEPARATOR);
    }
}
