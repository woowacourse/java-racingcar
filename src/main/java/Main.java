import domain.*;
import exception.CarNameLenExceedException;
import parser.CarNamesParser;
import parser.TrialParser;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    private static final String EMPTY = "";

    public static void main(String[] args) {
        RacingGame game = RacingGame.of(inputCars(), inputTrial());

        OutputView.printGame();
        while(game.hasTrial()) {
            Cars cars = game.doTrial(RandomMoveStrategy.DEFAULT);

            OutputView.printCars(cars.toDTO());
        }
        OutputView.printWinnerCars(game.findWinners().toDTO());
    }

    public static Cars inputCars() {
        String input = InputView.inputCarNames(EMPTY);

        while(true) {
            try {
                List<CarName> carNames = CarNamesParser.parse(input);
                return Cars.fromNames(carNames);
            } catch(CarNameLenExceedException | IllegalArgumentException e) {
                input = InputView.inputCarNames(e.getMessage());
            }
        }
    }

    public static Trial inputTrial() {
        String input = InputView.inputNumTrial(EMPTY);

        while(true) {
            try {
                return TrialParser.parse(input);
            } catch(NumberFormatException e) {
                input = InputView.inputNumTrial(e.getMessage());
            }
        }
    }
}
