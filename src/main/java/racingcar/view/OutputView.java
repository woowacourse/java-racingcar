package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printTryResultMenu() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTryResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        String winnerNames = String.join(", ", cars.findWinners(cars.calculateLongestDistance()));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
