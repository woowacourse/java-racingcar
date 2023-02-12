package view;

import domain.Car;
import java.util.List;

public class ResultView {
    public static void printPositionOfCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
    }
}
