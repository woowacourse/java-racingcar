package car.controller;

import static car.option.Option.MIN_TRIAL_COUNT;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;
import car.domain.Game;
import car.domain.RandomMoveChance;
import car.view.InputView;
import car.view.OutputView;

public class GameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final Game game;
    private final int trialCount;

    public GameController() {
        List<String> carNames = List.of(inputView.inputCarNames());
        game = new Game(makeCarsWith(carNames), new RandomMoveChance());
        trialCount = inputView.inputTrialCount();
        validateNotNegativeInteger(trialCount);
    }

    public void play() {
        outputView.noticeResult();
        playMultipleTimes();
    }

    public void showResult() {
        outputView.printCars(game.getCars());
        outputView.printWinners(game.findWinners());
    }

    private List<Car> makeCarsWith(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateNotNegativeInteger(int trialCount) {
        if (trialCount < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도횟수는 음수이면 안됩니다.");
        }
    }

    private void playMultipleTimes() {
        for (int i = 0; i < trialCount; i++) {
            game.playOnce();
            outputView.printCars(game.getCars());
        }
    }
}
