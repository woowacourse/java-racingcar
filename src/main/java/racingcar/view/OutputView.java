package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printAllCarsStatus(RacingCar racingCar) {
        System.out.println(racingCar);
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
