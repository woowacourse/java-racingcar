package view;

import domain.Car;

import java.util.ArrayList;

public class OutputView {

    public static void printWinners(ArrayList<Car> winners) {
        System.out.println("print winners");
    }

    public static void printCars(ArrayList<Car> cars) {
        System.out.println("각각 차들의 상태 출력");
    }

    public static void printMassage(String msg) {
        System.out.println(msg);
    }
}
