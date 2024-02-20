package racingcar.view;

import java.util.StringJoiner;

import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

public class OutputView {

    public void printProgressGuide() {
        System.out.println("\n실행 결과");
    }

    public void printProgress(Cars cars) {
        cars.stream().forEach(this::printCarProgress);
        System.out.println();
    }

    public void printWinners(Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        cars.stream().forEach(car -> stringJoiner.add(car.getName()));
        System.out.printf("%s가 최종 우승했습니다.", stringJoiner);
    }

    private void printCarProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getProgress()));
    }
}
