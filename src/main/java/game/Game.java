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

    boolean checkCarNameLength(String carNames) {
        return carNames.length() <= 5;
    }

    void createCarObject(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
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
}
