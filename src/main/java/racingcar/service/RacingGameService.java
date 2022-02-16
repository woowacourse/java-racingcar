package racingcar.service;

import racingcar.domain.dto.ResponseRoundResultDto;
import racingcar.domain.dto.ResponseWinnersDto;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Cars;

public class RacingGameService {

    private Cars cars;

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
