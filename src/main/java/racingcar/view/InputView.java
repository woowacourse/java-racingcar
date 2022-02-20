package racingcar.view;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRIAL_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Car> inputCars() {
        String carNames = inputCarNames();

        return Arrays.stream(splitNameWithoutSpace(carNames))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    private static String[] splitNameWithoutSpace(String carNames) {
        return carNames.replaceAll(SPACE, BLANK).split(COMMA);
    }

    public static String inputTrialNum() {
        System.out.println(INPUT_TRIAL_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
