package racing;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RepeatNumber;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racing.view.InputView.inputCarNames;

public class RacingGame {
    public void run() {
        RacingCars racingCars = new RacingCars(generateCarList());

        RepeatNumber repeatNumber = InputView.inputRepeatNumber();

        for (int i = 1; i <= repeatNumber.getNumber(); i++) {
            racingCars.race();
            OutputView.printStatus(racingCars.getRaceStatus());
        }
        OutputView.printWinners(racingCars.getWinners());

    }

    private List<Car> generateCarList() {
        try {
            return getCarNames().stream()
                    .map(name -> new Car(name))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return generateCarList();
        }
    }

    private List<String> getCarNames() {
        return Arrays.asList(inputCarNames().split(","));
    }
}
