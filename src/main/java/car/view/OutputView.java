package car.view;

import static car.option.Option.CAR_INFIX;
import static car.option.Option.POSITION_CHARACTER;
import static car.option.Option.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;

public class OutputView {
    public void noticeResult() {
        System.out.println("실행 결과");
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
        List<String> winnerNames = getCarNamesOf(winners);
        String joinedNames = String.join(WINNER_DELIMITER, winnerNames);
        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }

    private List<String> getCarNamesOf(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
