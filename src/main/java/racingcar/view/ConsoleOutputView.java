package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String RESULT_DELIMITER = " : ";
    private static final String DISTANCE_SYMBOL = "-";

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    @Override
    public void printRoundStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + RESULT_DELIMITER + DISTANCE_SYMBOL.repeat(car.getDistance()));
        }
    }
}
