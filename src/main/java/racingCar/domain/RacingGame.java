package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;

import java.util.List;

public class RacingGame {

    private final CarGroup cars;
    private final TryCount tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        this.cars = new CarGroup(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public List<CarDto> play(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        tryCount.decrease();
        return cars.toCarDtos();
    }

    public List<CarDto> findWinners() {
        return cars.findWinners();
    }

    public boolean isPlayable() {
        return !(tryCount.isZero());
    }
}
