package contoller;

import domain.Car;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import util.RandomUtil;
import view.InputView;
import view.OutputView;

public class RaceController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            return repeat(inputReader);
        }
    }

    public void run() {
        List<Car> cars = makeCars();
        int roundNum = repeat(inputView::readTrialNum);

        startRace(cars, roundNum);
        pickWinner(cars);
    }

    private List<Car> makeCars() {
        List<String> carNames = repeat(inputView::readCarNames);
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void startRace(List<Car> cars, int roundNum) {
        outputView.printStart(cars);
        for (int i = 0; i < roundNum; i++) {
            runRound(cars);
        }
    }

    private void runRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtil.getDigit());
        }
        outputView.printCarsStatus(cars);
    }

    private void pickWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        List<String> winnerNames = cars.stream().sorted()
            .filter(c -> c.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
        outputView.printWinners(winnerNames);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow()
            .getPosition();
    }
}
