package view;

import java.util.stream.Collectors;
import model.Car;
import model.Cars;

public class OutputView {

    public void printResultPrefix() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentRace(Cars cars) {
        cars.getCarList().forEach(car -> {
            System.out.printf("%s : %s\n", car.getCarName(), "-".repeat(car.getCarLocation()));
        });
        System.out.println();
    }

    public void printWinners(Cars cars) {
        String winners = cars.getCarList().stream()
                .filter(car -> car.getCarLocation() == cars.getMaxLocation())
                .map(Car::getCarName)
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
        System.out.println(winners);
    }
}
