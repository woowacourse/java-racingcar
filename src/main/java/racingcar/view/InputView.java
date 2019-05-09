package racingcar.view;

import racingcar.domain.Car;
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

    private static String makeString() {
        return SCANNER.nextLine();
    }
}
