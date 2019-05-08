package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printTrace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
