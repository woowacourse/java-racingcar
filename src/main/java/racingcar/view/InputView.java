package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.GameCount;
import racingcar.validator.CarInputValidator;
import racingcar.validator.GameCountInputValidator;
import racingcar.utils.ConvertUtils;
import racingcar.utils.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getCars(getUserInput());
    }

    public static List<Car> getCars(String input) {
        try {
            String[] inputs = input.split(DELIMITER);
            inputs = ConvertUtils.trim(inputs);
            CarInputValidator.checkAccuracyOfCarNames(inputs);
            return generateCars(inputs);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return getCars();
        }
    }

    private static List<Car> generateCars(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static GameCount getGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getGameCount(getUserInput());
    }

    public static GameCount getGameCount(String input) {
        try {
            input = input.trim();
            GameCountInputValidator.checkAccuracyOfGameCount(input);
            return new GameCount(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return getGameCount();
        }
    }

    private static String getUserInput() {
        return SCANNER.nextLine();
    }
}
