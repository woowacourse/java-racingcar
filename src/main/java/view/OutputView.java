package view;

import domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public static void printWinners(List<Car> winners) {
        String [] names = winners.stream().map((Car car) -> car.getName()).toArray(String []:: new);

        System.out.println(String.join("," ,names) +  " 가 최종 우승했습니다.");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(generateCarStatus(car));
        }
        System.out.println();
    }

    public static void printMassage(String msg) {
        System.out.println(msg);
    }

    private static String generateCarStatus(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName());
        sb.append(" : ");

        IntStream.range(0, car.getPosition()).forEach((i) -> sb.append("-"));

        return sb.toString();
    }
}
