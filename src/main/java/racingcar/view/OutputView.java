package racingcar.view;

import racingcar.vo.Car;
import racingcar.vo.Cars;
import racingcar.vo.Winners;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORM = "%s가 최종 우승했습니다.";

    public static void printRaceResult() {
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void printOnceResultWith(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.print(String.format(WINNER_MESSAGE_FORM, winners.toString()));
    }
}
