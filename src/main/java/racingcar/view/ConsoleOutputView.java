package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String RESULT_DELIMITER = " : ";
    private static final String DISTANCE_SYMBOL = "-";

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    @Override
    public void printRoundStatus(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.carName() + RESULT_DELIMITER + DISTANCE_SYMBOL.repeat(car.distance()));
        }
    }
}
