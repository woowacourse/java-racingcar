package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final String SPLIT_DELIM = ", ";
    private static final String OUTPUT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void racePrint(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void winnerPrint(List<String> winnerNames) {
        System.out.println(String.join(SPLIT_DELIM, winnerNames) + OUTPUT_WINNER_MESSAGE);
        lastLineBreak();
    }

    private static void lastLineBreak() {
        System.out.println();
    }
}
