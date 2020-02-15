package racingcar.application;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(generateCarsData());
        RacingRound racingRound = generateValidRound();

        run(carRacing, racingRound);
        findWinner(carRacing);
    }

    private static List<CarData> generateCarsData() {
        final int defaultDistance = 0;
        while (true) {
            try {
                List<Name> names = InputView.getNames();
                return names.stream()
                        .map(name -> new CarData(name, defaultDistance))
                        .collect(Collectors.toList());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static RacingRound generateValidRound() {
        while(true) {
            try {
                return InputView.getMoveNumber();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void run(CarRacing carRacing, RacingRound racingRound) {
        OutputView.printResultStart();
        for(int i = 0; i < racingRound.getRound(); i++) {
            carRacing.move();
            OutputView.printStatus(getCarData(carRacing.getCars()));
        }
    }

    private static void findWinner(CarRacing carRacing) {
        OutputView.printWinners(getCarData(carRacing.getWinners()));
    }

    private static List<CarData> getCarData(List<Car> cars) {
        return cars.stream()
                .map(Car::getCarData)
                .collect(Collectors.toList());
    }
}
