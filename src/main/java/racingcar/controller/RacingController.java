package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        RacingGame racingGame = initRacingGame();
        startRacing(racingGame);
        showWinners(racingGame);
    }

    private RacingGame initRacingGame() {
        String[] carNames = inputView.requestCarNames();
        int playTimes = inputView.requestPlayTimes();
        return new RacingGame(carNames, playTimes);
    }

    private void startRacing(RacingGame racingGame) {
        outputView.announceRacingStart();
        List<RoundResult> racingResults = racingGame.startRacing();
        outputView.recordScore(racingResults);
    }

    private void showWinners(RacingGame racingGame) {
        List<String> racingWinnerNames = extractCarNamesFromCars(racingGame);
        outputView.recordRacingWinners(racingWinnerNames);
    }

    private List<String> extractCarNamesFromCars(RacingGame racingGame) {
        return racingGame.findRacingWinners().stream()
                .map(Car::getName).collect(Collectors.toList());
    }
}
