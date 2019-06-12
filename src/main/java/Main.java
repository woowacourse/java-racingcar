import domain.CarName;
import domain.Cars;
import domain.RacingGame;
import domain.Trial;
import exception.CarNameLenExceedException;
import parser.CarNamesParser;
import parser.TrialParser;
import view.InputView;

import java.util.List;

public class Main {
    private static final String EMPTY = "";

    public static void main(String[] args) {
        RacingGame game = RacingGame.of(inputCars(), inputTrial());

        // 실행 결과
        while(game.hasTrial()) {
            Cars cars = game.doTrial(() -> true);

            // print cars
        }
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
