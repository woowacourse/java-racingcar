package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void printProgress(Cars cars) {
        System.out.println("실행 결과");
        cars.stream()
                .forEach(this::printCarProgress);
        System.out.println();
    }

    private void printCarProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getProgress()));
    }
}
