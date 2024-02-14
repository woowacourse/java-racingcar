package service;

import domain.Car;
import java.util.List;

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

    // TODO: 확장성 고려하기 -> move에 대한 전략이 바뀔 것을 대비
    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
