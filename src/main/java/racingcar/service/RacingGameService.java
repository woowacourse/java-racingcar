package racingcar.service;

import racingcar.dto.ResponseRoundResultDto;
import racingcar.dto.ResponseWinnersDto;
import racingcar.domain.vo.Attempt;
import racingcar.domain.fcc.Cars;

public class RacingGameService {

    private final Cars cars;

    public RacingGameService(Cars cars) {
        this.cars = cars;
    }

    public ResponseRoundResultDto racing(Attempt attempt) {
        return new ResponseRoundResultDto(cars.repeatRaceBy(attempt));
    }

    public ResponseWinnersDto findWinners() {
        return new ResponseWinnersDto(cars.findWinners());
    }
}
