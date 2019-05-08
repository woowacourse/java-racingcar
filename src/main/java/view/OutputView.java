package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printPosition(List<Car> CarList) {
        for (Car car : CarList) {
            System.out.println(car);
        }
    }



}
