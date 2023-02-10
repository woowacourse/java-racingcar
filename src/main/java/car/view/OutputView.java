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
        cars.stream()
                .forEach(car -> {
                    printTrack(car);
                });
        System.out.println();
    }

    private void printTrack(Car car) {
        System.out.print(car.getName() + CAR_INFIX);
        System.out.println(POSITION_CHARACTER.repeat(car.getPosition()));
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
