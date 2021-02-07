package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;
import utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    public static final int MIN_CAN_MOVE_NUMBER = 4;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    public static void start() {
        try {
            run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            start();
        }
    }

    public static void run() {
        Game game = initGame();
        playRace(game);
        OutputView.printWinners(getWinners(game));
    }

    private static Game initGame() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());

        return Game.init(carNames, trial);
    }

    private static void playRace(Game game) {
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
                   .filter(car -> car.isAtPosition(maxPosition))
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
