package controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import model.car.Car;
import model.car.Cars;
import model.manager.CarMoveManager;
import util.number.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<GameStatus, Supplier<GameStatus>> gameGuide;
    private final CarMoveManager carMoveManager;
    private final Cars cars = new Cars();

    public MainController(InputView inputView, OutputView outputView, CarMoveManager carMoveManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carMoveManager = carMoveManager;
        this.gameGuide = initializeGameGuide();
    }

    private Map<GameStatus, Supplier<GameStatus>> initializeGameGuide() {
        Map<GameStatus, Supplier<GameStatus>> gameGuide = new EnumMap<>(GameStatus.class);
        gameGuide.put(GameStatus.SET_GAME, this::setCars);
        gameGuide.put(GameStatus.PLAY_GAME, this::moveCars);
        return gameGuide;
    }

    public void play() {
        GameStatus gameStatus = progress(GameStatus.SET_GAME);
        while (gameStatus.isContinue(gameStatus)) {
            gameStatus = progress(gameStatus);
        }
    }

    private GameStatus progress(GameStatus gameStatus) {
        try {
            return gameGuide.get(gameStatus).get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return GameStatus.APPLICATION_EXIT;
        } catch (Exception exception) {
            // 에러로 인해 프로그램이 중단되지는 않지만, 예상치 못한 에러를 발견하기 어려운 문제...?
            return GameStatus.APPLICATION_EXIT;
        }
    }

    private GameStatus setCars() {
        List<String> carNames = inputView.readCarNames();
        carNames.stream().map(Car::new).forEach(cars::addCar);
        return GameStatus.PLAY_GAME;
    }


    private GameStatus moveCars() {
        int moveCount = inputView.readMoveCount();
        outputView.printResultMessage();
        moveAllCars(moveCount);
        outputView.printWinners(cars.getWinners());
        return GameStatus.APPLICATION_EXIT;
    }

    private void moveAllCars(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.cars().forEach(car -> car.move(isMove()));
            outputView.printResult(cars.cars());
        }
    }

    private boolean isMove() {
        return carMoveManager.isMove(RandomNumberGenerator.getRandomNumber());
    }

    private enum GameStatus {
        SET_GAME, PLAY_GAME, APPLICATION_EXIT;

        GameStatus() {
        }

        boolean isContinue(GameStatus gameStatus) {
            return !gameStatus.equals(APPLICATION_EXIT);
        }
    }
}
