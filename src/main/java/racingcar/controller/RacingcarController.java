package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private static final int RANDOM_NUM_MAX_VALUE = 10;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars cars = makeCars();
    private final TryCount tryCount = makeTryCount();

    private Cars makeCars() {
        try {
            outputView.printNameInput();
            return new Cars(inputView.readCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    private TryCount makeTryCount() {
        try {
            outputView.printCountInput();
            return new TryCount(inputView.readTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeTryCount();
        }
    }

    public void run() {
        play();
        finish();
    }

    private void play() {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            Map<String, Integer> roundResult = runRound();
            outputView.printRoundResult(roundResult);
            outputView.printNewLine();
        }
    }

    private void finish() {
        outputView.printRoundResult(finishRound());
        outputView.printWinners(finishGame());
    }

    public Map<String, Integer> runRound() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        Random random = new Random();
        for (Car car : cars.getCarInformation()) {
            int randomNumber = random.nextInt(RANDOM_NUM_MAX_VALUE);
            car.runForward(randomNumber);
            roundResult.put(car.getName().getName(), car.getDistance().getDistance());
        }
        return roundResult;
    }

    public Map<String, Integer> finishRound() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars.getCarInformation()) {
            roundResult.put(car.getName().getName(), car.getDistance().getDistance());
        }
        return roundResult;
    }

    public List<String> finishGame() {
        return cars.findWinner(cars.findMaxDistance());
    }
}
