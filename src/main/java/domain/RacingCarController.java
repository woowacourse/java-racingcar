package domain;

import java.util.List;
import view.InputView;

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
    }
}
