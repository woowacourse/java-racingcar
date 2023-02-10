package car.view;

import static car.option.Option.CAR_INFIX;
import static car.option.Option.POSITION_CHARACTER;
import static car.option.Option.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNERS_POSTFIX = "가 최종 우승했습니다.";

    public void noticeResult() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + CAR_INFIX);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
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
