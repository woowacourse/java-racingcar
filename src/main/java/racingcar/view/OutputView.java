package racingcar.view;

import racingcar.domain.RacingCar;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printAllCarsStatus(RacingCar racingCar) {
        System.out.println(racingCar);
    }
}
