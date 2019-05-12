package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RoundResult;

import java.util.ArrayList;

public class OutputView {
    public static void outputAllTryCarPosition(ArrayList<RoundResult> rounds) {
        System.out.println("\n실행 결과");
        for (RoundResult round : rounds) {
            outputCarPosition(round);
        }
    }

    private static void outputCarPosition(RoundResult round) {
        for (Car car : round.getRoundResult()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(ArrayList<Car> winners) {
        ArrayList<String> winnersName = new ArrayList<>();

        for (Car car : winners) {
            winnersName.add(car.getName());
        }
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
