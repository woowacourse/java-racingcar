package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    public static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.generateCar(name));
        }
        return cars;
    }

    public static void run(List<String> carNames, int trial) {
        Game game = Game.init(carNames, trial);
        race(game);
        //printWinner
    }

    private static void race(Game game) {
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
        if (RandomUtils.nextInt(0, 9) >= 4) { //TODO constant로 변경
            car.move();
        }
    }
}
