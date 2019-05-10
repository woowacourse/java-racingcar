package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingResult;

import java.util.List;

public class OutputView {
    public static void printRacingResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printRacingPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printRacingPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinner(RacingResult racingResult) {
        System.out.println(racingResult.toString() + "가 최종 우승했습니다.");
    }
}
