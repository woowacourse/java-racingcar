package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import javaracingcar.view.OutputView;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final int CAR_MOVES = 4;

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
        if (RandomUtils.nextInt(0, 9) >= CAR_MOVES) {
            car.move();
        }
    }

    public static List<Car> getWinners(Game game) {
        return game.getCars()
                   .stream()
                   .filter(car -> car.getPosition() == getMaxPosition(game))
                   .collect(Collectors.toList());
    }

    private static int getMaxPosition(Game game) {
        List<Integer> positions = game.getCars()
                                      .stream()
                                      .map(Car::getPosition)
                                      .collect(Collectors.toList());
        return Collections.max(positions);
    }
}
