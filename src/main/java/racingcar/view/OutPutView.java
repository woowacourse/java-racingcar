package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutPutView {

    public static void printStatusMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(makeCarStatus(car)));
        System.out.println();
    }

    private static String makeCarStatus(Car car) {
        String carStatus = car.getName() + " " + ":" + " ";
        int position = car.getPosition();

        while (position-- > 0) {
            carStatus += "-";
        }
        return carStatus;
    }

    public static void printResult(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
