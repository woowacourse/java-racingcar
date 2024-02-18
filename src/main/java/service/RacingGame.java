package service;

import domain.Car;

import java.util.List;

public class RacingGame {
    // TODO getter를 사용하지 않고 비교방식을 생각해보기
    // TODO 예외에 메시지를 담기

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_BOUNDARY_NUMBER = 4;

    public static List<String> getWinnerNames(List<Car> cars) {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(RuntimeException::new);

        return cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();
    }

    public static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            if (willMove()) {
                car.move();
            }
        }
    }

    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
