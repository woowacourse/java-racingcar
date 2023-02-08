package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final int count;

    public RacingGame(List<String> carNames, int count) {
        List<Car> collect = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(collect);
        this.count = count;
    }

    public void start() {
        // 메인 로직 (랜덤에 따른 전진 혹은 멈춤)
        OutputView.printResultMessage();

        for (int i = 0; i < count; i++) {
            cars.moveCars();
            OutputView.printState(cars);
        }

        OutputView.printState(cars);
        OutputView.printWinners(decideWinners());
    }

    private Cars decideWinners() {
        Cars winners = cars.getWinners();

        return winners;
    }
}
