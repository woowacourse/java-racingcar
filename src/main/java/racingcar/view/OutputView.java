package racingcar.view;

import racingcar.model.GameResult;
import racingcar.model.RacingCars;
import racingcar.model.Winner;

import java.util.List;

public class OutputView {
    private static final String EMPTY_STRING = "";
    private static final String SPACE_AND_COMMA = ", ";
    private static final String WINNER_MENT = "가 최종 우승했습니다.";
    private static final String RESULT_MENT = "실행결과";

    public static void printCarPositions(RacingCars racingCars) {
        System.out.println(racingCars.getCurrentPositionsOfRacingCars());
    }

    public static void printEmptyLine() {
        System.out.println(EMPTY_STRING);
    }

    public static void printCarWinners(Winner winner) {
        System.out.print(String.join(SPACE_AND_COMMA, winner.getWinnerNames()) + WINNER_MENT);
    }

    public static void printResultMent() {
        System.out.println(RESULT_MENT);
    }

    public static void printResults(GameResult gameResult) {
        System.out.println(gameResult.getAllResults());
    }
}
