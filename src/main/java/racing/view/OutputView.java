package racing.view;

import racing.car.Car;
import racing.car.Cars;
import racing.car.Winners;

public class OutputView {
    public static void printCarsInformation(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.print(String.format("%s : ", car.getName()));
            printProgressBar(car.getDistance());
        }
        System.out.println();
    }

    private static void printProgressBar(int distance) {
        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            bars.append("-");
        }
        System.out.println(bars.toString());
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winners.combine()));
    }

    public static void printProcess(Cars cars) {
        System.out.println("실행 결과");
        printCarsInformation(cars);
    }
}
