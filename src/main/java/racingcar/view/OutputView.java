package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.List;

public class OutputView {
    private static final String EMPTY_STRING = "";
    private static final String SPACE_AND_COMMA = ", ";
    private static final String WINNER_MENT = "가 최종 우승했습니다.";
    private static final String RESULT_MENT = "실행결과";

    public static void printCarPosition(Car car) {
        System.out.println(car.getCurrentPosition());
    }

    public static void printEmptyLine() {
        System.out.println(EMPTY_STRING);
    }

    public static void printCarWinners(Winner winner) {
        List<String> winners = winner.getWinnerCarNames();
        System.out.println(String.join(SPACE_AND_COMMA, winners) + WINNER_MENT);
    }

    public static void printResultMent() {
        System.out.println(RESULT_MENT);
    }
}
