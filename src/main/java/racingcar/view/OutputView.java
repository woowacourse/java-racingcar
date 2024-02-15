package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;

public class OutputView {
    private static final String WINNER_DESCRIPTION = "가 최종 우승했습니다.";
    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String NO_WINNER_DESCRIPTION = "최대 이동 거리가 0이므로 우승한 자동차가 없습니다.";

    public static void println() {
        System.out.println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printResultDescription() {
        println();
        println(RESULT_DESCRIPTION);
    }

    public static void printPosition(CarGroup carGroup) {
        println(carGroup.toString());
    }

    public static void printException(String message) {
        println(message);
    }

    public static void printWinnerList(List<Car> winnerGroup) {
        List<String> names = winnerGroup.stream()
                .map(Car::getName)
                .toList();

        String winnerNames = String.join(", ", names);
        println(winnerNames + WINNER_DESCRIPTION);
    }

    public static void printNoWinner() {
        println(NO_WINNER_DESCRIPTION);
    }
}
