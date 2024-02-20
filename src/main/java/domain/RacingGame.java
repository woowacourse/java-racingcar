package domain;

import dto.CarDto;
import dto.ResultDto;
import utils.PowerGenerator;
import utils.RandomPowerGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final CarGroup carGroup;
    private final PowerGenerator powerGenerator;

    public RacingGame(final String[] carNames) {
        this.carGroup = new CarGroup(carNames);
        this.powerGenerator = new RandomPowerGenerator();
    }

    RacingGame(final String[] carNames, final PowerGenerator powerGenerator) {
        this.carGroup = new CarGroup(carNames);
        this.powerGenerator = powerGenerator;
    }

    public List<ResultDto> race(final RacingGame racingGame, final Attempts attempts) {
        List<ResultDto> result = new ArrayList<>();

        while (!attempts.isEnd()) {
            racingGame.move();
            result.add(ResultDto.toDto(carGroup.getCars()));
            attempts.decrease();
        }

        return result;
    }

    public List<CarDto> getResult() {
        return carGroup.getWinners();
    }

    private void move() {
        for (Car car : carGroup.getCars()) {
            car.move(powerGenerator.getNumber());
        }
    }
}
