package racingcargame;

import racingcargame.domain.Car;
import racingcargame.domain.Cars;
import racingcargame.view.intput.InputView;
import racingcargame.view.output.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(parseCars(InputView.askCarNames()));
        cars.moveFoward(Integer.parseInt(InputView.askRound()));
        List<String> carNamesInFirst = cars.getCarsInMaxPosition();
        OutputView.printWinners(carNamesInFirst);
    }

    private static List<Car> parseCars(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames.stream().map(Car::new).collect(Collectors.toList());

    }
}
