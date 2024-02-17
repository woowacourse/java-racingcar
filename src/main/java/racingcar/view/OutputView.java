package racingcar.view;

import java.util.StringJoiner;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void printProgressGuide() {
        System.out.println("\n실행 결과");
    }

    public void printProgress(Cars cars) {
        cars.stream()
                .forEach(this::printCarProgress);
        System.out.println();
    }

    public void printWinners(Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        cars.stream()
                .forEach(car -> stringJoiner.add(car.getName()));
        System.out.printf("%s가 최종 우승했습니다.", stringJoiner);
    }

    private void printCarProgress(Car car) {
        String name = car.getName();
        String progress = "-".repeat(car.getProgress());
        System.out.printf("%s : %s%n%n", name, progress);
    }
}
