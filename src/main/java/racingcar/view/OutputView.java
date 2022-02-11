package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {
    public static final String RACE_RESULT_MESSAGE = "\n실행 결과";

    public static void printRaceResult(RacingGame cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCurrentPosition());
        }
        System.out.println();
    }

    public static void printChampionList(RacingGame cars) {
        String championNames = String.join(", ", cars.getChampionNames());
        System.out.println(championNames + "가 최종 우승했습니다.");
    }
}
