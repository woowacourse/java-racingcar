package racingcar.view;

import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RacingCarsRequest;

public interface InputView {
    RacingCarsRequest readRacingCars();

    RaceCountRequest readRaceCount();
}
