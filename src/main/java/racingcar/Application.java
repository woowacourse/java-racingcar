package racingcar;


import java.util.List;
import racingcar.domain.racing.CarRacing;
import racingcar.dto.CarRacingRequestDto;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.view.input.InputView;
import racingcar.view.output.ResultView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(getInputFromUser(), new RandomNumberGenerator());
        doRace(carRacing);
    }

    private static CarRacingRequestDto getInputFromUser() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int racingTryTime = inputView.getRacingTryTime();
        return new CarRacingRequestDto(carNames, racingTryTime);
    }

    private static void doRace(CarRacing carRacing) {
        ResultView resultView = new ResultView();
        while (!carRacing.isEnd()) {
            carRacing.raceOneTime();
            resultView.printCars(carRacing.getCars());
        }
        resultView.printWinners(carRacing.getWinners());
    }
}
