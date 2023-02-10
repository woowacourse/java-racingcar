package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import racingcar.domain.Car;
import racingcar.domain.GameCars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private GameCars gameCars = new GameCars(new ArrayList<>(), new ArrayList<>());
    private final int gameCount;

    public RacingCarApplication() {
        initRacing();
        this.gameCount = inputView.inputGameTime();
    }

    private void initRacing() {
        String[] input = inputView.inputCarName();
        Arrays.stream(input).forEach(s -> gameCars.getCars().add(new Car(s)));
    }

    public void playingGame() {
        for (int i = 0; i < gameCount; i++) {
            applyRandomNumberToCarPosition();
            outputView.printPosition(gameCars.getCars());
        }
    }

    private void applyRandomNumberToCarPosition() {
        gameCars.getCars().forEach(car -> {
            car.move(randomNumberGenerator.generate());
        });
    }

    public void printFinalResult() {
        int maxPosition = getCarMaxPosition();
        outputView.printPosition(gameCars.getCars());
        gameCars.getCars().stream().filter(car -> car.getPosition().getPosition() == maxPosition)
                .forEach(car -> gameCars.getWinners().add(car.getName().getName()));
        outputView.printWinners(gameCars.getWinners());
    }

    private int getCarMaxPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getIntPosition);

        Car carWithMaxPosition = gameCars.getCars().stream()
                .max(comparatorByPosition)
                .orElseThrow(NoSuchElementException::new);

        return carWithMaxPosition.getPosition().getPosition();
    }

}
