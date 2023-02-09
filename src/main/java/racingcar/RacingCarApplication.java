package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingCarApplication {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<String>();
    private final int gameCount;

    public RacingCarApplication() {
        initRacing();
        this.gameCount = inputView.inputGameTime();
    }

    private void initRacing() {
        String[] input = inputView.inputCarName();
        Arrays.stream(input).forEach(s -> cars.add(new Car(s)));
    }

    public void playingGame() {
        for (int i = 0; i < gameCount; i++) {
            moveCarPosition();
            outputView.printPosition(cars);
        }
    }

    private void moveCarPosition() {
        cars.forEach(car -> {
            car.move(randomNumberGenerator.generate());
        });
    }

    public void printFinalResult() {
        int maxPosition = getCarMaxPosition();
        outputView.printPosition(cars);
        cars.stream().filter(car -> car.getPosition() == maxPosition).forEach(car -> winners.add(car.getName()));
        outputView.printWinners(winners);
    }

    private int getCarMaxPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        Car carWithMaxPosition = cars.stream()
                .max(comparatorByPosition)
                .orElseThrow(NoSuchElementException::new);

        return carWithMaxPosition.getPosition();
    }

}
