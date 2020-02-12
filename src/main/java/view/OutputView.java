package view;

import model.Car;

import java.util.List;

public class OutputView {

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printPositionBar(car));
        }
        System.out.println();
    }

    public static String printPositionBar(Car car) {
        int position = car.getPosition();
        return makePositionBar(position);
    }

    private static String makePositionBar(int position) {
        return new String(new char[position]).replace("\0", "-");
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + " 가 우승했습니다.");
    }
}
