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
        final Race race = initCars();
        final int tryTime = inputView.readTryTime();
        race.initTryTime(tryTime);
        outputView.printResultTitle();
        startRace(race);
        outputView.printWinners(toCarDtos(race.getWinners()));
    }

    private void startRace(final Race race) {
        while (race.canRace()) {
            race.tryMoveOneTime(new RandomNumberPicker());
            final List<CarDto> carDtos = toCarDtos(race.getStatuses());
            outputView.printStatus(carDtos);
        }
    }

    private Race initCars() {
        final List<Car> cars = inputView.readCarNames().stream()
                .map(carDto -> new Car(carDto.getName()))
                .collect(Collectors.toUnmodifiableList());
        return new Race(cars);
    }

    private List<CarDto> toCarDtos(final List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
}
