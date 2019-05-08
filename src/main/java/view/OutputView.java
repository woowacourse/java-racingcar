package view;

import domain.Car;

import java.util.ArrayList;

public class OutputView {
    public static void printCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinningCars(ArrayList<Car> winningCars) {
        System.out.println("print winning");
    }
}
