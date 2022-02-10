package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        String[] names = Parser.split(carNames);

        Cars cars = new Cars(names);
        String rounds = InputView.inputRounds();
        Parser.isValidRounds(rounds);

        for (int i = 0; i < Integer.parseInt(rounds); i++) {
            cars.moveCars();
            OutputView.printRaceResult(cars);
        }

        OutputView.printChampionList(cars);
    }
}
