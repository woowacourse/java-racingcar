import static domain.ExceptionHandlingTemplate.repeatUntilReadValidInput;

import domain.Car;
import dto.CarDto;
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
        Race race = initCars();
        int tryTime = repeatUntilReadValidInput(this::validateTryTime, inputView::readTryTime);
        race.initTryTime(tryTime);
        outputView.printResultTitle();
        startRace(race);
        outputView.printWinners(toListCarDto(race.getWinners()));
    }

    private void startRace(Race race) {
        while (race.canRace()) {
            race.tryMoveOneTime(new RandomNumberPicker());
            List<CarDto> carDtos = toListCarDto(race.getStatuses());
            outputView.printStatus(carDtos);
        }
    }

    private Race initCars() {
        List<Car> cars = inputView.readCarNames().stream()
                .map(carDto -> new Car(carDto.getName()))
                .collect(Collectors.toUnmodifiableList());
        return new Race(cars);
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
