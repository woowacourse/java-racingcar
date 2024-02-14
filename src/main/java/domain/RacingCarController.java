package domain;

import java.util.List;
import java.util.Random;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void run() {
        List<String> carNames = InputView.inputNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        int count = InputView.inputTryCount();
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 회 이상이어야 합니다.");
        }

        OutputView.printResultTitle();

        for (int i = 0; i < count; i++) {
            cars.forEach((car) -> {
                Random random = new Random();
                int randomInt = Math.abs(random.nextInt() % 10);
                car.move(randomInt >= 4);
            });

            OutputView.printProgress(cars);
        }

        int maxPosition = cars.stream().mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
        OutputView.printWinners(winners);
    }
}
