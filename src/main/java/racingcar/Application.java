package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static final int POSITIVE_CRITERIA = 1;

    public static void main(String[] args) {
        String inputNames = InputView.receiveNameInput();
        Cars cars = new Cars(inputNames);

        int count = InputView.receiveCountInput();
        validatePositiveNumber(count);

        OutputView.showResult();

        showRaceResult(cars, count);

        OutputView.showWinners(cars.getWinners());
    }

    protected static void validatePositiveNumber(int countInput) {
        if (countInput < POSITIVE_CRITERIA) {
            throw new IllegalArgumentException(POSITIVE_CRITERIA + "이상의 수를 입력해야합니다.");
        }
    }

    private static void showRaceResult(Cars cars, int count) {
        Race race = new Race();

        for (int i = 0; i < count; i++) {
            cars.getCars().stream()
                    .forEach(car -> race.racing(car));

            OutputView.showEachRaceResult(cars.getCars());
        }
    }
}
