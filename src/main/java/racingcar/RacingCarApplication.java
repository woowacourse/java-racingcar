package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.domain.Winners;
import racingcar.view.InputView;

import static racingcar.view.OutputView.printWinners;

public class RacingCarApplication {

    public static void main(String[] args) {
        //TODO: 컨트롤러와 메인을 역할을 나눴는데 뭐가더 나은 방법인지..?
        Cars cars = inputCarNames();
        Lap lap = inputLap();

        final var racingController = new RacingController();
        racingController.start(cars, lap);
        Winners winners = new Winners(cars.getCars());

        printWinners(winners);
    }

    private static Lap inputLap() {
        try {
            return new Lap(InputView.inputTotalLap());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLap();
        }
    }

    private static Cars inputCarNames() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }
}
