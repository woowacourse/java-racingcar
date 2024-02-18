package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {


    public void printTryResult(Cars cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
    }

    public void printWinners(Cars cars) {
        String winnerNames = String.join(", ", cars.findWinners(cars.calculateLongestDistance()));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
