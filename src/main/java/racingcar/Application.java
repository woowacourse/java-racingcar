package racingcar;


import java.util.List;
import racingcar.domain.racing.CarRacing;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.view.CarRacingInputs;
import racingcar.view.input.InputView;
import racingcar.view.output.ResultView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(getInputFromUser(), new RandomNumberGenerator());
        doRace(carRacing);
    }

    private static CarRacingInputs getInputFromUser() {
        List<String> carNames = InputView.getCarNames();
        int racingTryTime = InputView.getRacingTryTime();
        return new CarRacingInputs(carNames, racingTryTime);
    }

    private static void doRace(CarRacing carRacing) {
        while (!carRacing.isEnd()) {
            carRacing.raceOneTime();
            ResultView.printCars(carRacing.getCars());
        }
        ResultView.printWinners(carRacing.getWinners());
    }
}
