package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomConstructor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacing {
    public static void main(String[] args) {
        String inputNames = InputView.receiveNameInput();
        int count = InputView.receiveCountInput();
        validatePositiveNumber(count);

        Cars cars = new Cars(inputNames);
        OutputView.showResult();
        RandomConstructor randomConstructor = new RandomConstructor();

        for (int i = 0; i < count; i++) {
            for (Car car : cars.getCars()) {
                int randomValue = randomConstructor.getRandomNumber();
                car.movePositionAccordingToCondition(randomValue);
            }
            OutputView.showRace(cars.getCars());
        }

        OutputView.showWinner(cars.getWinners());
    }

    protected static void validatePositiveNumber(int numberInput) {
        if (numberInput < 1) {
            throw new IllegalArgumentException("2이상의 수를 입력해야합니다.");
        }
    }
}
