import domain.Car;
import dto.CarDto;
import domain.Race;
import domain.RandomNumberPicker;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Race race = initRace();
        outputView.printResultTitle();
        startRace(race);
        outputView.printWinners(toCarDtos(race.getWinners()));
    }

    private Race initRace() {
        Race race = repeatUntilInitialValid(Race::new, this::toCars, inputView::readCarNames);
        repeatUntilInitialValid(race::initTryTime, inputView::readTryTime);
        return race;
    }

    private void startRace(final Race race) {
        while (race.canRace()) {
            race.tryMoveOneTime(new RandomNumberPicker());
            final List<CarDto> carDtos = toCarDtos(race.getStatuses());
            outputView.printStatus(carDtos);
        }
    }

    private List<CarDto> toCarDtos(final List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Car> toCars(final List<CarDto> cars) {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }


    private <T, U, R> R repeatUntilInitialValid(final Function<U, R> object, final Function<T, U> mapper
            , final Supplier<T> reader) {
        try {
            T input = reader.get();
            U mapped = mapper.apply(input);
            return object.apply(mapped);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilInitialValid(object, mapper, reader);
        }
    }

    private <T> void repeatUntilInitialValid(final Consumer<T> object, final Supplier<T> reader) {
        try {
            object.accept(reader.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            repeatUntilInitialValid(object, reader);
        }
    }
}
