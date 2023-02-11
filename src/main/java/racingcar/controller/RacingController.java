package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private static final String SEPARATOR = ",";

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Track init(MovingStrategy movingStrategy) {
        Cars cars = requestCars(movingStrategy);
        String trialTime = requestTrialTime();
        outputView.printCurrentCarsPosition(cars);

        return new Track(cars, trialTime);
    }

    private Cars requestCars(MovingStrategy movingStrategy) {
        String carNames = inputView.inputCarNames();
        List<Car> cars = Arrays.stream(carNames.split(SEPARATOR))
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private String requestTrialTime() {
        return inputView.inputTrialTimes();
    }

    public void startRace(Track track) {
        while (track.runnable()) {
            Cars cars = track.race();
            outputView.printCurrentCarsPosition(cars);
        }
    }

    public void concludeWinner(Track track) {
        outputView.printWinnerCars(track.findWinner());
    }

    public void terminated(String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }
}
