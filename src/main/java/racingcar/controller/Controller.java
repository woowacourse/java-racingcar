package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Trial;

public class Controller {
    private static final String DELIMITER = ",";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RandomNumberGenerator randomNumberGenerator;

    private final Cars cars;
    private final Trial trial;

    public Controller() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(initializeCars());
        this.trial = initGameTime();
    }

    private Trial initGameTime() {
        String trial = inputView.inputGameTime();
        return new Trial(trial);
    }

    private List<Car> initializeCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void startRacing() {
        for (int i = 0; i < trial.getTrial(); i++) {
            applyRandomNumberToCarPosition();
            outputView.printPosition(cars.getCars());
        }
    }

    private void applyRandomNumberToCarPosition() {
        cars.getCars().forEach(car -> {
            car.move(randomNumberGenerator.generate());
        });
    }

    public void endRacing() {
        outputView.printWinners(cars.getWinnerNames());
    }

}
