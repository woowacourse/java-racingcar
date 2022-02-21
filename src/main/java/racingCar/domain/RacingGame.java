package racingCar.domain;

import java.util.List;
import racingCar.domain.dto.CarDto;
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
        List<CarDto> winnerCarsDto = cars.getSamePositionCarsDto(cars.getMaxPosition());
        return new CarsDto(winnerCarsDto);
    }

    public CarsDto getCarsDto() {
        return new CarsDto(cars.getDto());
    }

    public RoundCount getRoundCount() {
        return roundCount;
    }
}