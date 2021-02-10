package racingcar;


import java.util.List;
import racingcar.domain.racing.CarRacing;
import racingcar.view.input.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int racingTryTime = inputView.getRacingTryTime();

        CarRacing carRacing = new CarRacing(carNames, racingTryTime);
        doRace(carRacing);
    }

    private static void doRace(CarRacing carRacing) {
        while(!carRacing.isEnd()) {
            carRacing.raceOneTime();
            ResultView.printCars(carRacing.getCars());
        }
        ResultView.printWinners(carRacing.getWinners());
    }
}
