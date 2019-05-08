package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Car> carList = new ArrayList<>();

    String inputCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return sc.nextLine();
    }

    String removeBlank(String carNames) {
        return carNames.replace(" ", "");
    }

    String[] splitWithComma(String carNames) {
        return carNames.split(",");
    }

    boolean checkCarNamesLength(String[] carNames) {
        boolean isRightLength = true;

        for (String carName : carNames) {
            isRightLength = checkCarNameLength(isRightLength, carName);
        }

        return isRightLength;
    }

    boolean checkCarNameLength(boolean isRightLength, String carName) {
        return carName.length() <= 5 && isRightLength;
    }

    void createCarObject(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    String[] carNameGenerator() {
        String[] carNames = splitWithComma(removeBlank(inputCarNames()));

        if (checkCarNamesLength(carNames)) {
            return carNames;
        }

        return carNameGenerator();
    }

    int inputGameCount() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("시도할 회수는 몇회인가요?");
            return sc.nextInt();
        } catch(InputMismatchException e) {
            return inputGameCount();
        }
    }

    int randomValueGenerator() {
        return (int) (Math.random() * 9);
    }

    void checkStopOrMove(Car car, int random) {
        if (random >= 4) {
            car.move();
        }
    }
}
