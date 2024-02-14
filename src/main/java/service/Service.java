package service;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static int RANDOM_NUMBER_RANGE = 10;
    private static int MOVE_BOUNDARY_NUMBER = 4;

    public static void moveForward(Car car) {
        if (willMove()) {
            car.move();
        }
    }

    public static List<String> getWinnerNames(List<Car> cars) {
        int maxScore = cars.stream()
            .mapToInt(Car::getScore)
            .max()
            .orElseThrow(RuntimeException::new);

        List<String> winnerNames = cars.stream()
            .filter(car -> car.getScore() == maxScore)
            .map(Car::getName)
            .toList();

        return winnerNames;
    }

    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
