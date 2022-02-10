package racingcar.view;

import racingcar.Car;

import java.util.List;

public class OutputView {
    public static void getRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String result = car.getName() + " : ";
            result += makePositionString(car);
            System.out.println(result);
        }
    }

    static String makePositionString(Car car) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
