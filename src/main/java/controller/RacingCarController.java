package controller;

import domain.RacingCar;
import domain.RacingCarNames;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    public void start() {
        RacingCarNames racingCarNames = readRacingCarNames();
        List<RacingCar> racingCars = racingCarNames.createRacingCars();
        TryNumber tryNumber = readTryNumber();

        OutputView.printRacingStartMessage();
        do {
            tryRacing(racingCars);
            tryNumber.decrease();
        } while(tryNumber.isTryable());
    }

    private void tryRacing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
            printResult(racingCar);
        }
        System.out.println();
    }

    public void printResult(RacingCar racingCar) {
        OutputView.printResult(racingCar.getName(), racingCar.getMoveNumber());
    }

    private RacingCarNames readRacingCarNames() {
            String carNames = InputView.inputCarNames();
            return new RacingCarNames(carNames);
    }

    private TryNumber readTryNumber() {
        String input = InputView.inputMoveCount();
        return new TryNumber(Integer.parseInt(input));
    }
}
