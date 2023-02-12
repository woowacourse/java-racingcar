package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void tryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void error(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void playRound() {
        System.out.println("\n실행 결과");
    }

    public static void result(Cars cars) {
        List<String> carsResult = cars.getResult();

        for (String result : carsResult) {
            System.out.println(result);
        }
        System.out.println();
    }

    public static void winner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
