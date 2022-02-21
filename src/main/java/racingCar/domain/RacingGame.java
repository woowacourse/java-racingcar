package racingCar.domain;

import racingCar.domain.dto.CarsDto;
import racingCar.domain.dto.InitDto;
import racingCar.domain.moveStrategy.RandomNumGenerator;

public class RacingGame {
    private final Cars cars;
    private final RoundCount roundCount;

    public RacingGame(InitDto initDto) {
        this.cars = new Cars(initDto.getNames());
        this.roundCount = new RoundCount(initDto.getCount());
    }

    public void go() {
        cars.go(new RandomNumGenerator());
        roundCount.minusOne();
    }

    public CarsDto getWinnerCarsDto() {
        return cars.getSamePositionCarsDto(cars.getMaxPosition());
    }

    public CarsDto getCarsDto() {
        return cars.toDto();
    }

    public RoundCount getRoundCount() {
        return roundCount;
    }
}