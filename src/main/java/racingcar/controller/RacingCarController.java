package racingcar.controller;

import racingcar.domain.CarRepository;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingCarController {
    private final RacingGame racingGame;

    public RacingCarController() {
        this.racingGame = initGame();
    }

    public void run() {
        OutputView.printResultMessage();
        race();
        showFinalResult();
    }

    private RacingGame initGame() {
        CarRepository carRepository = createCars();
        int tries = getTries();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return new RacingGame(carRepository, tries, numberGenerator);
    }
    //,를 제거했을 때 빈 리스트가 되는 경우 예외 처리한다.
    //플레이어가 1명 이하인 경우 예외 처리한다.

    private CarRepository createCars() {
        String input = InputView.inputCarNames();
        List<String> carNames = splitCarNames(input);
        return new CarRepository(carNames);
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private int getTries() {
        try {
            return InputView.inputTries();
        } catch (InputMismatchException e) {
            return getTries();
        }
    }

    private void race() {
        while (!racingGame.isFinish()) {
            List<CarStatus> turnResult = racingGame.takeOneTurn();
            OutputView.printCarStatus(turnResult);
        }
    }

    private void showFinalResult() {
        List<CarStatus> finalPosition = racingGame.getFinalPosition();
        OutputView.printCarStatus(finalPosition);
        prizeWinner();
    }

    private void prizeWinner() {
        List<String> winnersName = racingGame.getWinnersName();
        OutputView.printFinalResult(winnersName);
    }
}
