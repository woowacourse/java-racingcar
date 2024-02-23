package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.model.MoveHistory;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        List<String> names = readCarNames();
        int moveCount = readMoveCount();
        CarGroup carGroup = initCars(names);

        List<MoveHistory> moveHistories = play(carGroup, moveCount);
        finish(moveHistories, carGroup);
    }

    private List<String> readCarNames() {
        OutputView.printlnInputName();
        return InputView.inputNames();
    }

    private int readMoveCount() {
        OutputView.printlnInputMoveCount();
        return InputView.inputMoveCount();
    }

    private CarGroup initCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new CarGroup(cars);
    }

    private List<MoveHistory> play(CarGroup carGroup, int moveCount) {
        List<MoveHistory> moveHistories = new ArrayList<>();
        for (int i = 0; i < moveCount; i++) {
            MoveHistory moveHistory = carGroup.race(new RandomNumberGenerator());
            moveHistories.add(moveHistory);
        }
        return moveHistories;
    }

    private void finish(List<MoveHistory> moveHistories, CarGroup carGroup) {
        OutputView.printResultDescription();
        OutputView.printMoveHistories(moveHistories);

        List<Car> winners = carGroup.findWinners();
        if (winners.isEmpty()) {
            OutputView.printNoWinner();
            return;
        }

        OutputView.printWinnerList(winners);
    }
}
