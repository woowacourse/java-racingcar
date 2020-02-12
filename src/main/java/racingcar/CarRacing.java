package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomConstructor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacing {
    public static void main(String[] args) {
        String inputNames = InputView.receiveNameInput();
        int cnt = InputView.receiveCountInput();
        Cars cars = new Cars(inputNames);

        OutputView.showResult();

        RandomConstructor randomConstructor = new RandomConstructor();
        for (int i = 0; i < cnt; i++) {
            for(Car car : cars.getCars()) {
                int randomValue = randomConstructor.getRandomNumber();
                car.movePositionAccordingToCondition(randomValue);
            }
            OutputView.showRace(cars.getCars());
        }

        OutputView.showWinner(cars.getWinners());
    }
}
