package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.GameCount;
import racingcar.error.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getCars(makeString());
    }

    public static List<Car> getCars(String input) {
        try {
            String[] inputs = input.split(",");
            Validator.checkAccuracyOfCarNames(inputs);
            return makeCarList(inputs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private static List<Car> makeCarList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static GameCount getGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getGameCount(makeString());
    }

    public static GameCount getGameCount(String input) {
        try {
            input = input.trim();
            Validator.checkAccuracyOfGameCount(input);
            return new GameCount(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCount();
        }
    }

    private static String makeString() {
        return SCANNER.nextLine();
    }
}
