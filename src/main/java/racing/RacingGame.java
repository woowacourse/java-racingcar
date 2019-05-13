package racing;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RepeatNumber;
import racing.view.ConsoleMessages;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public void run() {
        RacingCars racingCars = new RacingCars(generateCars());

        startRace(racingCars, inputRepeatNumber());

        OutputView.printWinners(racingCars.getWinners());
    }

    private List<Car> generateCars() {
        try {
            return getCarNames().stream()
                    .map(name -> new Car(name))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return generateCars();
        }
    }

    private List<String> getCarNames() {
        List<String> splitNames = Arrays.asList(InputView.inputCarNames().split(","));

        if (splitNames.isEmpty()){
            throw new IllegalArgumentException(ConsoleMessages.ERR_CAR_BLANK_NAME.getMessage());
        }
        return splitNames;
    }

    private static RepeatNumber inputRepeatNumber() {
        return toRepeatNumber(InputView.inputRepeatNumber());
    }


    private static RepeatNumber toRepeatNumber(String number) {
        try {
            return new RepeatNumber(number);
        } catch (NumberFormatException e) {
            System.err.println(ConsoleMessages.ERR_REPEAT_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return inputRepeatNumber();
    }

    private void startRace(RacingCars racingCars, RepeatNumber repeatNumber) {
        for (int i = 0; i < repeatNumber.getNumber(); i++) {
            racingCars.race();
            OutputView.printStatus(racingCars.getRaceStatus());
        }
    }
}
