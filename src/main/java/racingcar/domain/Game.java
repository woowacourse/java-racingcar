package racingcar.domain;

import racingcar.util.RandomUtils;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final CarRepository carRepository = new CarRepository();
    private final int totalRounds;

    public Game(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.add(new Car(name));
        }
    }

    public void playAllRounds() {
        List<Car> cars = carRepository.findAllCars();

        OutputView.printRoundResultText();
        for (int i = 0; i < totalRounds; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    private void playRound() {
        List<Car> cars = carRepository.findAllCars();

        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        List<Car> cars = carRepository.findAllCars();

        int maxPosition = 0;

        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (maxPosition > currentPosition) {
                continue;
            }
            if (maxPosition < currentPosition) {
                winners.clear();
            }
            winners.add(car);
            maxPosition = currentPosition;
        }
        return winners;
    }
}
