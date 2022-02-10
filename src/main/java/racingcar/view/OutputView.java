package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    public static void printCarsPosition(Cars cars) {
        System.out.print(cars);
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }
}
