package racingcar.io;

import java.util.Scanner;

public class Input {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRIALS = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public int inputTrials() {
        System.out.println(INPUT_TRIALS);
        return validateNumeric(scanner.nextLine());
    }

    private int validateNumeric(String numberInput) {
        if (!matchStringIsNumber(numberInput)) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return Integer.parseInt(numberInput);
    }

    private boolean matchStringIsNumber(String numberInput) {
        return numberInput.chars().allMatch(Character::isDigit);
    }
}
