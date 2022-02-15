package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.utils.CarsGenerator;
import racingcar.utils.validator.RoundNumberValidator;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<Car> getCars() {
        String userInput = userCarNameInput();
        try {
            return CarsGenerator.generateCars(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private static String userCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int getRound() {
        String roundNumberString = userRoundInput();
        try {
            return toIntWithValidate(roundNumberString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRound();
        }
    }

    private static int toIntWithValidate(String roundNumberString) {
        RoundNumberValidator.validate(roundNumberString);
        return Integer.parseInt(roundNumberString);
    }

    private static String userRoundInput() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
