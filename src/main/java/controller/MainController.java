package controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import model.car.Stadium;
import model.manager.ThresholdCarMoveManager;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<GameStatus, Supplier<GameStatus>> gameGuide;

    private Stadium stadium;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameGuide = initializeGameGuide();
    }

    private Map<GameStatus, Supplier<GameStatus>> initializeGameGuide() {
        Map<GameStatus, Supplier<GameStatus>> gameGuide = new EnumMap<>(GameStatus.class);
        gameGuide.put(GameStatus.SET_CARS, this::setCars);
        gameGuide.put(GameStatus.MOVE_CARS, this::moveCars);
        return gameGuide;
    }

    public void play() {
        GameStatus gameStatus = progress(GameStatus.SET_CARS);
        while (gameStatus.isContinue(gameStatus)) {
            gameStatus = progress(gameStatus);
        }
    }

    private GameStatus progress(GameStatus gameStatus) {
        try {
            return gameGuide.get(gameStatus).get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return gameStatus;
        } catch (NullPointerException exception) {
            return GameStatus.APPLICATION_EXIT;
        } catch (Exception exception){
            return GameStatus.APPLICATION_EXIT;
        }
    }

    private GameStatus moveCars() {
        int moveCount = inputView.readMoveCount();
        outputView.printResultMessage();
        moveAllCars(moveCount);
        outputView.printWinners(stadium.getWinners());
        return GameStatus.APPLICATION_EXIT;
    }

    private GameStatus setCars() {
        List<String> carNames = inputView.readCarNames();
        stadium = new Stadium(carNames, new ThresholdCarMoveManager());
        return GameStatus.MOVE_CARS;
    }

    private void moveAllCars(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            stadium.moveAllCarsOnce();
            outputView.printResult(stadium.getCurrentResult());
        }
    }

    private enum GameStatus {
        SET_CARS, MOVE_CARS, APPLICATION_EXIT;

        GameStatus() {
        }

        boolean isContinue(GameStatus gameStatus) {
            return !gameStatus.equals(APPLICATION_EXIT);
        }
    }
}
