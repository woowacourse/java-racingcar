package racingcar.io;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static void printResultTitle() {
        System.out.println("실행 결과\n");
    }

    public static void printCars(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append(" : ");
            sb.append(positionVisualized(car));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String positionVisualized(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners + "이(가) 우승했습니다.");
    }
}
