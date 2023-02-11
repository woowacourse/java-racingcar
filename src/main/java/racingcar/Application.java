package racingcar;

import java.util.List;
import racingcar.domain.NumberPicker;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberPicker;
import racingcar.dto.CreateRacingCarsDto;
import racingcar.util.Repeat;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingCars racingCars = initializeRacingCars();
        race(racingCars);
//        OutputView.printResult(racingCars.getAllLogs(), racingCars.result());
    }

    private static RacingCars initializeRacingCars() {
        return Repeat.repeatIfError(Application::createRacingCars, OutputView::printErrorMessage);
    }

    private static RacingCars createRacingCars() {
        List<String> carNames = InputView.inputCarName();
        int tryCount = InputView.inputTryCount();
        return new RacingCars(new CreateRacingCarsDto(tryCount, carNames));
    }

    private static void race(RacingCars racingCars) {
        OutputView.printStatusGuide();
        racingCars.race(numberPicker(), OutputView::printStatus);
    }


    private static NumberPicker numberPicker() {
        return new RandomNumberPicker();
    }

}
