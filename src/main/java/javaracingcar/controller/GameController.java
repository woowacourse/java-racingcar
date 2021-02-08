package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.RacingGame;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {


    public static void start() {
        try {
            run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            start();
        }
    }

    public static void run() {
        RacingGame racingGame = initGame();
        playRace(racingGame);
        OutputView.printWinners(getWinners(racingGame));
    }

    private static RacingGame initGame() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());

        return RacingGame.init(carNames, trial);
    }

    private static void playRace(RacingGame racingGame) {
        OutputView.printResultTitle();
        racingGame.playRace();
    }

    public static List<Car> getWinners(RacingGame racingGame) {
        int maxPosition = getMaxPosition(racingGame);
        return racingGame.getCars()
                         .stream()
                         .filter(car -> car.isAtPosition(maxPosition))
                         .collect(Collectors.toList());
    }

    private static int getMaxPosition(RacingGame racingGame) {
        return racingGame.getCars()
                         .stream()
                         .mapToInt(Car::getPosition)
                         .max()
                         .orElseThrow(() -> new IllegalArgumentException("Max Position 구하는데에 실패했습니다."));
    }
}
