package racingcar.util;

public class CarNameParser {
    private static final String CAR_NAME_DELIMINATOR = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static String[] parseCarNameInputs(String inputs) {
        String[] carNames = removeBlank(inputs).split(CAR_NAME_DELIMINATOR);
        return carNames;
    }

    private static String removeBlank(String text) {
        return text.replaceAll(BLANK, EMPTY);
    }
}
