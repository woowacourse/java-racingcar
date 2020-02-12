package racingcargame.util;

public class Spliter {

    public static final String DELIMITER = ",";

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }
}
