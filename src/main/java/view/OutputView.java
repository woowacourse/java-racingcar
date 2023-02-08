package view;

import domain.Car;
import domain.Cars;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(
                String.format(CAR_RESULT_FORMAT, car.getName(), car.getMovePosition()));
        }
        System.out.println();
    }
}
