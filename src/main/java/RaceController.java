import static domain.ExceptionHandlingTemplate.repeatUntilReadValidInput;

import domain.Car;
import domain.CarDto;
import domain.Race;
import domain.RandomNumberPicker;
import java.util.List;
import java.util.stream.Collectors;
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
            race.tryMoveOneTime(new RandomNumberPicker());
            List<CarDto> carDtos = toListCarDto(race.getStatuses());
            outputView.printStatus(carDtos);
        }

        outputView.printWinners(toListCarDto(race.getWinners()));
    }

    private List<CarDto> toListCarDto(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private int validateTryTime(int tryTime) {
        if (tryTime < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
        return tryTime;
    }
}
