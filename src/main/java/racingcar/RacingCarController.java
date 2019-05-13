package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        String userInput = InputView.getUserCarNames();
        int numOfGame = InputView.getNumberOfGame();

        RacingCar racingCar = new RacingCar();
        ArrayList<Integer>[] carPositionHistory = racingCar.process(userInput, numOfGame);

        String[] carNames = racingCar.splitCarNames(userInput);
        OutputView.printCarPositionHistory(carNames, carPositionHistory);

        List<String> winners = RacingWinners.process(carNames, carPositionHistory);
        OutputView.printWinners(winners);
    }
}
