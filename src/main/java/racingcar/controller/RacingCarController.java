package racingcar.controller;

import racingcar.domain.CarRepository;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingCarController {

    public void run() {
        RacingGame racingGame = initGame();
    }

    private RacingGame initGame() {
        CarRepository carRepository = createCars();
        int tries = getTries();
        return new RacingGame(carRepository, tries);
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
}
