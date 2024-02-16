package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String MESSAGE_NOT_EXIST_CAR = "생성된 자동차가 없습니다.";

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

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
