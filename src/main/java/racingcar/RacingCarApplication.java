package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    private static final String DELIMITER = ",";

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final Cars cars;
    private final int gameCount;

    public RacingCarApplication() {
        this.cars = new Cars(initializeCars());
        this.gameCount = inputView.inputGameTime();
    }

    private List<Car> initializeCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split).map(Car::new).collect(Collectors.toList());
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
