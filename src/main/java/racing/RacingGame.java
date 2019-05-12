package racing;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RepeatNumber;
import racing.view.ErrorMessages;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public void run() {
        RacingCars racingCars = new RacingCars(generateCars());

        startRace(racingCars, InputView.inputRepeatNumber());

        OutputView.printWinners(racingCars.getWinners());
    }

    private List<Car> generateCars() {
        try {
            return splitNames().stream()
                    .map(name -> new Car(name))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return generateCars();
        }
    }

    private List<String> splitNames() {
        List<String> names = Arrays.asList(InputView.inputCarNames().split(","));

        if (names.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.NAME_NULL.getMessage());
        }

        return names;
    }

    private void startRace(RacingCars racingCars, RepeatNumber repeatNumber) {
        for (int i = 0; i < repeatNumber.getNumber(); i++) {
            racingCars.race();
            OutputView.printStatus(racingCars.getRaceStatus());
        }
    }
}
