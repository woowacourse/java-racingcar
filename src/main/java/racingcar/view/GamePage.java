package racingcar.view;

import racingcar.domain.car.CarRepository;

public class GamePage {

    private GamePage() {
        throw new IllegalStateException("GamePage is an utility class");
    }

    public static void printResultPage() {
        System.out.println("\n실행 결과");
    }

    public static void printSingleRoundResult() {
        CarRepository.cars()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printFinalResult(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
