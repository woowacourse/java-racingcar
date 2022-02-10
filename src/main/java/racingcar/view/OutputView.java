package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String TRIAL_RESULT = "\n실행 결과";

    public static void printCarPosition(Cars cars) {
        cars.getCars().forEach(OutputView::printCarResult);
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.println(car.getName() + " : " + makeDash(car.getPosition()));
    }

    private static String makeDash(int position) {
        return "-".repeat(Math.max(0, position));
    }

    public static void printTrialResult() {
        System.out.println(TRIAL_RESULT);
    }

    public static void printWinnerName(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
