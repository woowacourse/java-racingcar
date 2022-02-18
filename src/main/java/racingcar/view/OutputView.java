package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Result;

import java.util.stream.Collectors;

public class OutputView {
    private static final String TRIAL_RESULT = System.lineSeparator() + "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String COMMA = ", ";
    private static final int MINIMUM_POSITION = 0;

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarPosition(Cars cars) {
        cars.getCars().forEach(OutputView::printCarResult);
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

    public static void printWinnerName(Result result) {
        System.out.println(result.getWinners().getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA))
                + WINNER_MESSAGE);
    }
}
