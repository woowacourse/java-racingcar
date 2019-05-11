package view;

import domain.Car;
import domain.Winner;

import java.util.List;

public class OutputView {

    public static void printStartUI() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printCar(car));
        }
        System.out.println();
    }

    private static String printCar(Car car) {
        return car.getName() + " : " + new String(new char[car.getPosition()]).replace("\0", "-");
    }

    public static void printWinnerName(List<Car> cars) {
        Winner winner = new Winner(cars);
        String result = String.join(",", winner.getWinnerNames());
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
