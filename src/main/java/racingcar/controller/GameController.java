package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.RandomNumberList;
import racingcar.util.IntegerConst;
import racingcar.util.StringConst;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void runRace() {
        try {
            OutputView.askCarName();
            CarList carList = new CarList(InputView.getCarNameInput());
            OutputView.askTurn();
            int totalTurn = InputView.getTurnInput();
            playGame(totalTurn, carList);
        } catch (IllegalArgumentException error) {
            OutputView.displayError(error.getMessage());
        }
    }

    private void playGame(int totalTurn, CarList carList) {
        OutputView.displayResult();
        for (int nowTurn = IntegerConst.ZERO.getValue(); nowTurn < totalTurn; nowTurn++) {
            moveCarList(carList);
            OutputView.displayCarPosition(carList.getNameList(), carList.getEachCarPosition(),
                StringConst.POSITION_DELEIMIER.getValue());
        }
        OutputView.displayWinner(carList.getWinnerNames());
    }

    private void moveCarList(CarList carList) {
        int size = carList.getTotalCount();
        RandomNumberList randomNumberList = new RandomNumberList(size);
        for (int index = IntegerConst.ZERO.getValue(); index < size; index++) {
            carList.moveCarAt(index, randomNumberList.getNumberAt(index));
        }
    }
}
