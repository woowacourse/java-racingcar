package racingcar.controller;

import java.util.List;
import racingcar.constants.CarConstant;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final CarService carService;
    private int tryCount;

    public RacingcarController(CarService carService) {
        this.carService = carService;
    }

    public void start() {
        carService.initializeCars();
        while (readNameInput()) {
            carService.initializeCars();
        }
        while (readCountInput()) {
        }
    }

    private boolean readNameInput() {
        try {
            OutputView.printNameInput();
            List<String> carNames = splitCarNames(InputView.readCarNames());
            carService.makeCar(carNames);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private boolean readCountInput() {
        try {
            OutputView.printCountInput();
            tryCount = InputView.readTryCount();
            validateNegativeCount(tryCount);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void validateNegativeCount(int tryCount) {
        int minTryCount = CarConstant.MIN_TRY_COUNT.getNumber();
        if (tryCount <= minTryCount) {
            throw new IllegalArgumentException(String.format("[ERROR] 시도할 횟수는 %d보다 큰 숫자여야 합니다.", minTryCount));
        }
    }

    public void run() {
        OutputView.printResultMessage();
        for (int i = 1; i <= tryCount; i++) {
            carService.runRound(i);
            OutputView.printRoundResult(carService.getCarsStatus());
        }
    }

    public void finish() {
        OutputView.printRoundResult(carService.getCarsStatus());
        OutputView.printWinners(carService.findWinner());
    }
}
