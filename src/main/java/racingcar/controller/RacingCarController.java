package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.utils.CarsGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public List<String> getCarNames() {
        return InputView.getCarNames();
    }

    public int getRound() {
        return InputView.getRound();
    }

    public void printRoundResultMessage() {
        OutputView.printRoundResultMessage();
    }

    public void printRoundResult(List<Car> raceResult) {
        OutputView.printRoundResult(raceResult);
    }

    public void printWinners(List<Car> winners) {
        OutputView.printWinners(winners);
    }

    public List<Car> generateCars(List<String> carNames) {
        return CarsGenerator.generateCars(carNames);
    }
}
