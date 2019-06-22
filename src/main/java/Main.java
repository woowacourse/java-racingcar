import domain.*;
import dto.CarDto;
import exception.CarNameLenExceedException;
import parser.CarNameParser;
import parser.TrialParser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String EMPTY_NOTIFYING_MESSAGE = "";

    public static void main(String[] args) {
        RacingGame game = RacingGame.of(inputCars(), inputTrial());

        OutputView.printGame();
        while (game.hasTrial()) {
            Cars cars = game.doTrial(RandomMoveStrategy.DEFAULT);

            OutputView.printCars(toCarDtos(cars));
        }
        Cars winnerCars = game.findWinners();
        OutputView.printWinnerCars(toCarDtos(winnerCars));
    }

    public static Cars inputCars() {
        String input = InputView.inputCarNames(EMPTY_NOTIFYING_MESSAGE);

        while (true) {
            try {
                List<CarName> carNames = CarNameParser.parseCarNames(input);
                return Cars.fromNames(carNames);
            } catch (CarNameLenExceedException | IllegalArgumentException e) {
                input = InputView.inputCarNames(e.getMessage());
            }
        }
    }

    public static Trial inputTrial() {
        String input = InputView.inputNumTrial(EMPTY_NOTIFYING_MESSAGE);

        while (true) {
            try {
                return TrialParser.parse(input);
            } catch (NumberFormatException e) {
                input = InputView.inputNumTrial(e.getMessage());
            }
        }
    }

    private static List<CarDto> toCarDtos(Cars cars) {
        List<CarDto> dtos =new ArrayList<>();
        for (Car car : cars) {
            dtos.add(toCarDto(car));
        }

        return dtos;
    }

    private static CarDto toCarDto(Car car) {
        return CarDto.of(car.getName(), car.getNumDistance());
    }
}
