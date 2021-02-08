package racingCar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void validateCarNamesInput(String carNamesInput) {
        validateNullOrEmpty(carNamesInput);
        if (carNamesInput.charAt(0) == ',' || carNamesInput.charAt(carNamesInput.length() - 1) == ',') {
            throw new IllegalArgumentException("시작이나 끝에 콤마(,)가 올 수 없습니다.");
        }
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 있어야 합니다.");
        }
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = scanner.nextLine();
        validateCarNamesInput(carNamesInput);
        return carNamesInput;
    }

    public static int getRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String raceCountInput = scanner.nextLine();
        validateRaceCountInput(raceCountInput);
        System.out.println();
        return Integer.parseInt(raceCountInput);
    }

    public static void validateRaceCountInput(String raceCountInput) {
        validateNullOrEmpty(raceCountInput);
        if (!raceCountInput.chars().allMatch(Character::isDigit) || raceCountInput.charAt(0) == '0') {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
    }
}
