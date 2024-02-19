package racingcar.view;

import java.util.List;
import java.util.Scanner;

import static racingcar.message.ErrorMessage.MESSAGE_ONLY_NUMBER;
import static racingcar.validator.Validator.*;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarName() {
        String input = scanner.nextLine();
        List<String> splitCarNames;
        try {
            validateNoSpace(input);
            splitCarNames = getSplitCarNames(input);
            validateLengthOfCarNames(splitCarNames);
            validateNoDuplicatedCarNames(splitCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarName();
        }
        return splitCarNames;
    }

    public int getTryCount() {
        String input = scanner.nextLine();
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
            validateNaturalNumber(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            System.out.println(MESSAGE_ONLY_NUMBER.getMessage());
            return getTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
    }

    private List<String> getSplitCarNames(String input) {
        return List.of(input.split(","));
    }
}
