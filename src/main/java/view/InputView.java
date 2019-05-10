package view;

import model.Car;
import model.CarName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String regexCarNames = "^([^,]+)(,[^,]+)*$";

    public static List<Car> inputCarsNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
            String carNames = scanner.nextLine();
            checkFormCarNames(carNames);
            return parseCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarsNames();
        }
    }

    private static List<Car> parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            Car car = new Car(new CarName(carName));
            checkCarNamesDuplication(cars, car);
            cars.add(car);
        }
        return cars;
    }

    private static void checkCarNamesDuplication(List<Car> cars, Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    private static void checkFormCarNames(String carNames) {
        if (!carNames.matches(regexCarNames)) {
            throw new IllegalArgumentException("자동차 이름 형식에 맞지 않습니다.");
        }
    }

    public static int inputLapCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int lapCount = parseInteger(scanner.nextLine());
            checkArrangeLapCount(lapCount);
            return lapCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLapCount();
        }
    }

    private static int parseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void checkArrangeLapCount(int lapCount) {
        if (lapCount <= 0) {
            throw new IllegalArgumentException("시도 횟수를 자연수로 입력해주세요");
        }
    }
}
