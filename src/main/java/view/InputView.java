package view;

import domain.Car;
import domain.Cars;
import domain.Count;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Cars getCarNames() {
        try {
            return collectCars(getUserInputNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getCarNames();
    }

    private static Cars collectCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private static List<String> getUserInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(scanner.nextLine().split(",")).toList();
    }


    public static Count getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new Count(Integer.parseInt(scanner.nextLine()));
    }
}
