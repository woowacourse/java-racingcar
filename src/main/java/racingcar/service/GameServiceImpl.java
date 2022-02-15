package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.CarGroup;
import racingcar.domain.car.CarStatusDto;
import racingcar.domain.round.Round;
import racingcar.service.picker.NumberPicker;

public class GameServiceImpl implements GameService {

    private final NumberPicker numberPicker;
    private CarGroup carGroup;
    private Round round;

    public GameServiceImpl(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void initCarNames(List<String> carNames) {
        this.carGroup = new CarGroup(carNames);
    }

    public void initRound(int count) {
        this.round = new Round(count);
    }

    public boolean isContinuable() {
        return (round.isNotFinished());
    }

    public void playRound() {
        carGroup.goForwardOrStop(numberPicker);
        round.decreaseCount();
    }

    public List<String> getCurrentStatuses() {
        List<CarStatusDto> statuses = carGroup.getStatuses();
        return statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        return carGroup.getWinnerNames();
    }

}
