package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import javaracingcar.view.OutputView;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    public static final int MIN_CAN_MOVE_NUMBER = 4;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    public static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.generateCar(name));
        }
        return cars;
    }

    public static void run(List<String> carNames, int trial) throws IllegalArgumentException {
        Game game = Game.init(carNames, trial);
        race(game);
        OutputView.printWinners(getWinners(game));
    }

    private static void race(Game game) {
        OutputView.printResultTitle();
        while (!game.isEnd()) {
            playOneRound(game);
            game.reduceOneTrial();
        }
    }

    private static void playOneRound(Game game) {
        playMoveOrStop(game.getCars());
        OutputView.printRoundResult(game);
    }

    private static void playMoveOrStop(List<Car> cars) {
        cars.forEach(GameController::playMoveOrStop);
    }

    private static void playMoveOrStop(Car car) {
        if (generateRandomNumber() >= MIN_CAN_MOVE_NUMBER) {
            car.move();
        }
    }

    private static int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public static List<Car> getWinners(Game game) {
        int maxPosition = getMaxPosition(game);
        return game.getCars()
                   .stream()
                   .filter(car -> car.getPosition() == maxPosition)
                   .collect(Collectors.toList());
    }

    private static int getMaxPosition(Game game) {
        return game.getCars()
                   .stream()
                   .mapToInt(Car::getPosition)
                   .max()
                   .orElseThrow(() -> new IllegalArgumentException("Max Position 구하는데에 실패했습니다."));
    }
}
