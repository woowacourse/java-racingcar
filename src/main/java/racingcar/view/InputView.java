package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    private static final String COMMA_REGEX = ",";

    public String[] getNames() {
        String[] names = splitByComma(scanner.nextLine());
        return names;
    }

    public String[] splitByComma(String input) {
        return input.split(COMMA_REGEX);
    }

    public int getCoin() {
        String input = scanner.nextLine();
        inputValidator.isNumeric(input);
        int coin = Integer.parseInt(input);
        inputValidator.isNaturalNumber(coin);
        return coin;
    }

}
