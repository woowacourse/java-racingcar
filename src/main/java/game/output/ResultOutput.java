package game.output;

import game.Car;

import java.util.List;

public class ResultOutput {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void printEachGame(List<Car> cars) {
        for (Car car : cars) {
            printEachCar(car);
        }

        printNewLine();
    }

    private static void printEachCar(Car car) {
        init();

        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }

        System.out.println(stringBuilder);
    }

    public static void printWinners(List<String> winners) {
        init();

        stringBuilder.append(String.join(", ", winners));
        stringBuilder.append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }

    public static void printNewLine() {
        System.out.println();
    }

    private static void init() {
        stringBuilder.setLength(0);
    }
}