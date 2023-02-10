package car.controller;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;
import car.domain.Game;
import car.domain.RandomMoveChance;
import car.view.InputView;
import car.view.OutputView;

public class GameController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final int MIN_TRIAL_COUNT = 0;

    private final Game game;
    private final int trialCount;

    public GameController() {
        List<String> carNames = List.of(INPUT_VIEW.inputCarNames());
        game = new Game(makeCarsWith(carNames), new RandomMoveChance());
        trialCount = INPUT_VIEW.inputTrialCount();
        validateNotNegativeInteger(trialCount);
    }

    public void play() {
        OUTPUT_VIEW.noticeResult();
        playMultipleTimes();
    }

    public void showResult() {
        OUTPUT_VIEW.printStatusOf(game.getCars());
        OUTPUT_VIEW.printWinners(game.findWinners());
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
            OUTPUT_VIEW.printStatusOf(game.getCars());
        }
    }
}
