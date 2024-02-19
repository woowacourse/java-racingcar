package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printTryResult(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
    }

    public void printWinners(List<Car> winningCars) {
        String winnerNames = String.join(", ",
                winningCars.stream()
                        .map(Car::getName)
                        .toList());

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
