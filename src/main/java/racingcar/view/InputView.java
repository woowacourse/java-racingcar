package racingcar.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.utils.Constant;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int MINIMUM_NATURAL_NUMBER = 1;

    private static final String COIN_PATTERN_REGEX = "^[0-9]*$";


    private static final Pattern COIN_PATTERN = Pattern.compile(COIN_PATTERN_REGEX);


    public static String getCarNames() {
        System.out.println(Constant.PRINT_CAR_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int getTryNo() {
        System.out.println(Constant.PRINT_GET_TRY_NO_MESSAGE);
        String input = scanner.nextLine();
        return checkTryNo(input);
    }


    private static int checkTryNo(String input) {
        isNumeric(input);
        int tryNo = Integer.parseInt(input);
        isNaturalNumber(tryNo);
        return tryNo;

    }

    private static void isNumeric(String input) {
        Matcher matcher = COIN_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Constant.NOT_NUMERIC_ERROR);
        }
    }

    private static void isNaturalNumber(int input) {
        if (input < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(Constant.MINIMUM_NATURAL_NUMBER_ERROR);
        }
    }

}
