package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.CarStatusDto;
import racingcar.domain.car.Cars;
import racingcar.domain.round.Round;
import racingcar.service.picker.NumberPicker;

public class GameService {

    private final NumberPicker numberPicker;
    private Cars cars;
    private Round round;

    public GameService(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void initCarNames(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public void initRound(int count) {
        this.round = new Round(count);
    }

    public boolean isContinuable() {
        return round.isNotFinished();
    }

    public void playRound() {
        cars.goForwardOrStop(numberPicker);
        round.decreaseCount();
    }

    public List<String> getCurrentStatuses() {
        List<CarStatusDto> statuses = cars.getStatuses();
        return statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNames();
    }

}
