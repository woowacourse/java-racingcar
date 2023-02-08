package racingcar;

import java.util.List;

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

    public static void result(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
