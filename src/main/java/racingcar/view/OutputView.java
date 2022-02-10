package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String TRIAL_RESULT = "실행결과";

    public static void printCarPosition(Cars cars) {
        cars.getCars().forEach(OutputView::printCarResult);
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.println(car.getName() + " : " + makeDash(car.getPosition()));
    }

    private static String makeDash(int position) {
        StringBuilder dash = new StringBuilder();
        dash.append("-".repeat(Math.max(0, position)));

        return dash.toString();
    }

    public static void printTrialResult() {
        System.out.println(TRIAL_RESULT);
    }
}
