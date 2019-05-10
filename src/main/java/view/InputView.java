package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.StringUtil.parseStringByComma;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = scanner.nextLine();
        return getCarList(inputString);
    }

    public static List<Car> getCarList(String inputString) {
        List<String> names = parseStringByComma(inputString);
        List<Car> cars = new ArrayList<>();

        for (String carName : names) {
            try {
                cars.add(new Car(carName));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return createCars();
            }
        }
        return cars;
    }

    public static int inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요");
            return  inputTryNum();
        }
    }


}
