package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Winners;
import racingcar.view.io.OutputView;

public class RacingCarView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printNowProgressResult(final RacingCar racingCar) {
        OutputView.printString(RESULT_HEADER_MESSAGE);
        racingCar.getNowCars().forEach(RacingCarView::printCarStatus);
        OutputView.printBlankLine();
    }

    public static void printFinalResult(final Winners winners) {
        OutputView.printString(String.join(", ", winners.getWinnersNames()) + FINAL_RESULT_MESSAGE);
    }

    private static void printCarStatus(final Car car) {
        OutputView.printString(car.getName() + " : " + getProgressBarStatus(car.getPosition()));
    }

    private static String getProgressBarStatus(final int carPosition) {
        StringBuilder progressBarStatus = new StringBuilder();
        for (int i = 0; i < carPosition; ++i) {
            progressBarStatus.append('-');
        }
        return progressBarStatus.toString();
    }
}
