import static domain.ExceptionHandlingTemplate.repeatUntilReadValidInput;

import domain.CarDto;
import domain.Race;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Race race = repeatUntilReadValidInput(Race::new, inputView::readCarNames);
        int tryTime = repeatUntilReadValidInput(this::validateTryTime, inputView::readTryTime);

        outputView.printResultTitle();
        while (tryTime-- > 0) {
            race.tryMoveOneTime();
            List<CarDto> cars = race.getCarDTOs();
            outputView.printStatus(cars);
        }

        outputView.printWinners(race.judgeWinners());
    }

    private int validateTryTime(int tryTime) {
        if (tryTime < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
        return tryTime;
    }
}
