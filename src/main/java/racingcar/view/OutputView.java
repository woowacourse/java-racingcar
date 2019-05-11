package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void outputAllTryCarPosition(List<RaceResult> eachTryCars) {
        System.out.println("\n실행 결과");
        for (RaceResult cars : eachTryCars) {
            outputCarsPosition(cars.getCars());
        }
    }

    private static void outputCarsPosition(List<Car> cars) {
        StringBuffer output = new StringBuffer();

        for (Car car : cars) {
            output.append(car.getName());
            output.append(" : ");
            output.append(carPositionToDash(car));
            output.append("\n");
        }
        System.out.println(output);
    }

    private static StringBuffer carPositionToDash(Car car) {
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < car.getPosition(); i++) {
            output.append("-");
        }
        return output;
    }

    public static void outputWinners(List<Car> winningCars) {
        List<String> winnersName = new ArrayList<>();

        for (Car car : winningCars) {
            winnersName.add(car.getName());
        }
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
