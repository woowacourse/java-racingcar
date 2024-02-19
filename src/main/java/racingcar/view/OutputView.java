package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printRequestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static String makeCarInfo(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    private static void printRoundResult(List<Car> roundResult) {
        roundResult.forEach(car -> {
            String carInfo = makeCarInfo(car);
            System.out.println(carInfo);
        });
    }

    public static void printGameResults(List<List<Car>> gameResult) {
        System.out.println("\n실행 결과");
        gameResult.forEach(roundResult -> {
            printRoundResult(roundResult);
            System.out.println();
        });
    }
}
