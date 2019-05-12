package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRounds() {
        System.out.println("\n실행 결과");
    }
    public static void printEachRound(List<Car> cars) {
        cars.forEach(car -> System.out.println(car + " : " + drawTrail(car.getPosition())));
        System.out.println();
    }

    private static String drawTrail(int position) {
        StringBuffer trail = new StringBuffer();
        for (int i = 0; i < position; i++) {
            trail.append("-");
        }
        return trail.toString();
    }

    public static void printWinners(List<Car> winners) {
        String result = winners.toString();
        result = result.substring(1, result.length() - 1);
        System.out.println(
                result
                + HangulPostposition.differentiateIGa(result)
                + " 최종 우승했습니다."
        );
    }
}