package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.Winners;

import java.util.List;

public class OutputView {
    private static final String TRIAL_RESULT = "\n실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final int MINIMUM_POSITION = 0;

    public static void printCarPosition(RacingGame racingGame) {
        racingGame.getCars().getCars().forEach(OutputView::printCarResult);
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.println(car.getName() + COLON + makeDash(car.getPosition()));
    }

    private static String makeDash(int position) {
        return DASH.repeat(Math.max(MINIMUM_POSITION, position));
    }

    public static void printTrialResult() {
        System.out.println(TRIAL_RESULT);
    }

    public static void printWinnerName(Winners winners) {
        System.out.println(makeWinnerNamePrintFormat(winners.getWinnerCarNames()));
    }

    private static String makeWinnerNamePrintFormat(List<String> winnerCarNames) {
        return String.join(WINNER_DELIMITER, winnerCarNames) + WINNER_MESSAGE;
    }
}
