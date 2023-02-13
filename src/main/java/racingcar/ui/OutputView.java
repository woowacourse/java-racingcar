package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    private static final String CAR_BASE_STATUS = "-";

    public static void error(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void tryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void playRound() {
        System.out.println("\n실행 결과");
    }

    public void result(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + CAR_BASE_STATUS.repeat(car.getPosition()));
        }

        System.out.println();
    }

    public void winner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
