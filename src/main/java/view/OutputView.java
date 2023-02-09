package view;

import static utils.Constant.POSITION_BAR;
import static utils.Constant.WINNER_NAME_DELIMITER;
import static utils.Notice.ENTER_CAR_NAME;
import static utils.Notice.ENTER_TRY_TIMES;
import static utils.Notice.FINAL_WINNER;
import static utils.Notice.RESULT;

import domain.Car;
import domain.CarRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printInputCarNamesNotice() {
        System.out.println(ENTER_CAR_NAME.of());
    }

    public static void printInputTryTimesNotice() {
        System.out.println(ENTER_TRY_TIMES.of());
    }

    public static void printCarNameAndPosition(CarRepository carRepository) {
        Map<Car, Integer> cars = carRepository.getCarBoard();
        for (Car car : cars.keySet()) {
            String carName = car.getName();
            Integer position = cars.get(car);
            System.out.println(carName + " : " + POSITION_BAR.repeat(position));
        }
        System.out.println();
    }

    public static void printResultNotice() {
        System.out.println(RESULT.of());
    }

    public static void printWinner(List<Car> winnerCars) {
        List<String> winnerCarNames = winnerCars.stream()
            .map(
                Car::getName
            ).collect(Collectors.toList());
        System.out.println(String.join(WINNER_NAME_DELIMITER, winnerCarNames) + FINAL_WINNER.of());
    }
}
