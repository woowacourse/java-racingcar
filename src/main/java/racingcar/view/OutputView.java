package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class OutputView {
    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER_COLON = " : ";
    private static final String POSITION_HYPHEN = "-";

    private OutputView() {
    }

    public static void printRunResult(List<Cars> runResult) {
        System.out.println(RUN_RESULT_MESSAGE);
        for (Cars cars : runResult) {
            printCars(cars);
        }
    }

    private static void printCars(Cars cars) {
        List<Car> carsValue = cars.getCars();
        for (Car car : carsValue) {
            System.out.println(car.getName() + DELIMITER_COLON + printPosition(car.getPosition()));
        }
        System.out.println();
    }

    private static String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_HYPHEN);
        }

        return stringBuilder.toString();
    }
}