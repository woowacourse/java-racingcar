package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCurrentPosition());
        }
    }

    public static void printChampionList(Cars cars) {
        String championNames = String.join(", ", cars.getChampions());
        System.out.println(championNames + "가 최종 우승했습니다.");
    }
}
