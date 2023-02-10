package car.view;

import static car.option.Option.CAR_DELIMITER;
import static car.option.Option.CAR_INFIX;
import static car.option.Option.POSITION_CHARACTER;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNERS_POSTFIX = "가 최종 우승했습니다.";

    public void noticeResult() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printStatusOf(List<Car> cars) {
        for (Car car : cars) {
            printStatusOf(car);
        }
        System.out.println();
    }

    private void printStatusOf(Car car) {
        int fromZeroToPosition = car.getPosition();
        String progress = POSITION_CHARACTER.repeat(fromZeroToPosition);
        System.out.println(car.getName() + CAR_INFIX + progress);
    }

    public void printWinners(List<Car> winners) {
        System.out.println(joinCarNamesOf(winners) + WINNERS_POSTFIX);
    }

    private String joinCarNamesOf(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(CAR_DELIMITER));
    }
}
