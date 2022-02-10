package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    public static void racePrint(List<Car> carList) {
        for (Car car : carList) {
            car.showInfo();
        }
        System.out.println();
    }

    public static void winnerPrint(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) +"가 최종 우승했습니다. ");

    }
}
