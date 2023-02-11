package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    private final Cars cars;
    private final int gameCount;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(initializeCars());
        this.gameCount = inputView.inputGameTime();
    }

    private List<Car> initializeCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void startRacing() {
        for (int i = 0; i < gameCount; i++) {
            applyRandomNumberToCarPosition();
            outputView.printPosition(cars.getCars());
        }
    }

    private void applyRandomNumberToCarPosition() {
        cars.getCars().forEach(car -> {
            car.move(randomNumberGenerator.generate());
        });
    }

    public void endRacing(){
        outputView.printWinners(cars.getWinnerNames());
    }

}
