package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    public List<String> getCarNamesList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            return inputCarNamesString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getCarNamesList();
        }
    }

    public int getRacingGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        try {
            return inputGameCountString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getRacingGameCount();
        }
    }

    private List<String> inputCarNamesString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무 이름도 입력하지 않으셨습니다. 다시 입력해주세요.");
        }

        return Arrays.stream(input.split(","))
            .map(Input::trimStringAndCheckEmptyName)
            .collect(Collectors.toList());
    }

    private static String trimStringAndCheckEmptyName(String string) {
        String trimString = string.trim();

        if (trimString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공란이 있습니다. 다시 입력해주세요.");
        }

        return trimString;
    }

    private int inputGameCountString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공란이 있습니다. 다시 입력하세요.");
        }

        try {
            return parseInt(input);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getRacingGameCount();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 포함되었습니다. 다시 입력하세요.");
        }
    }
}
