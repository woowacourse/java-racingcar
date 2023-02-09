package racingCar;

import racingCar.domain.CarGroup;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    public void run() {
        CarGroup carGroup = repeat(this::makeCars);
        Integer tryCount = repeat(InputView::readTryCount);
        for (int i = 0; i < tryCount; i++) {
            carGroup.moveCars(CarGroup.NUMBER_RANGE_MIN, CarGroup.NUMBER_RANGE_MAX);
            OutputView.printCarPosition(carGroup.toCarDtos());
        }
        carGroup.findWinners();
    }


    private CarGroup makeCars() {
        List<String> carNames = repeat(InputView::readCarNames);
        CarGroup carGroup = new CarGroup(carNames);
        return carGroup;
    }

    private static <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
