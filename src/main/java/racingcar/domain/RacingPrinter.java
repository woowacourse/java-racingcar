package racingcar.domain;

import static racingcar.input.utils.carname.CarNamesInputFromUser.CAR_NAMES_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

public class RacingPrinter {
    private final CarRepository carRepository;
    private final String POSITION_SIGN = "-";

    public RacingPrinter(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void printRacingStartMessage() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public void printAllCarsCurrentPosition() {
        List<Car> cars = carRepository.getCars();
        cars.forEach(this::printEachCarCurrentPosition);
    }

    private void printEachCarCurrentPosition(Car car) {
        System.out.println(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.println(POSITION_SIGN);
        }
        printNewLine();
    }

    public void printWinners() {
        List<Car> winners = carRepository.getWinners();
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print(String.join(CAR_NAMES_DELIMITER + " ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private void printNewLine() {
        System.out.print("\n");
    }
}
