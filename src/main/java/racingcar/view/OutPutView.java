package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutPutView {

    public static void printStatusMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printStatus(List<Car> cars) {
        System.out.println();

        for (Car car : cars) {
            System.out.println(makeCarStatus(car));
        }
    }

    private static String makeCarStatus(Car car) {
        String carStatus = car.getName() + " " + ":" + " ";
        int position = car.getPosition();

        while (position-- > 0) {
            carStatus += "-";
        }
        return carStatus;
    }
}
