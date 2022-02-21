package racingcar.service;

import java.util.List;
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

    public ResponseRoundResultDto racing(Attempt attempt, List<List<Integer>> numberSet) {
        return new ResponseRoundResultDto(cars.repeatRaceBy(attempt, numberSet));
    }

    public ResponseWinnersDto findWinners() {
        return new ResponseWinnersDto(cars.findWinners());
    }
}
