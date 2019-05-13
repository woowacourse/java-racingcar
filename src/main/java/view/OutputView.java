package view;

import domain.Car;

import java.util.List;

public class OutputView {

    public static void printWinners(List<Car> winners) {
        String [] names = winners.stream().map((Car car) -> car.getName()).toArray(String []:: new);

        System.out.println(String.join("," ,names) +  " 가 최종 우승했습니다.");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatusString());
        }
        System.out.println();
    }

    public static void printMassage(String msg) {
        System.out.println(msg);
    }
}
