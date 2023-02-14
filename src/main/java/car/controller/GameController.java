package car.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import car.domain.Car;
import car.domain.Game;
import car.domain.MoveChance;
import car.domain.RandomMoveChance;
import car.view.InputView;
import car.view.OutputView;

public class GameController {

    private static final String EXCEPTION_PREFIX = "[ERROR]";

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private final Game game;
    private final MoveChance moveChance = new RandomMoveChance();

    public GameController() {
        game = createGame();
    }

    private Game createGame() {
        return handleExceptionByRepeating(() -> {
            List<String> carNames = INPUT_VIEW.inputCarNames();
            int trialCount = INPUT_VIEW.inputTrialCount();
            return new Game(makeCarsWith(carNames), trialCount);
        });
    }

    public void play() {
        OUTPUT_VIEW.noticeResult();
        playMultipleTimes();
        showResult();
    }

    private List<Car> makeCarsWith(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void playMultipleTimes() {
        while (game.isNotDone()) {
            game.playOnceWith(moveChance);
            OUTPUT_VIEW.printStatusOf(game.getCars());
        }
    }

    private void showResult() {
        OUTPUT_VIEW.printStatusOf(game.getCars());
        OUTPUT_VIEW.printWinners(game.findWinners());
    }

    private <T> T handleExceptionByRepeating(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            System.out.println(EXCEPTION_PREFIX + exception.getMessage());
            return handleExceptionByRepeating(supplier);
        }
    }
}
