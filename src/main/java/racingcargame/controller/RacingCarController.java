package racingcargame.controller;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.MoveStrategy;
import racingcargame.domain.RacingCars;
import racingcargame.domain.RacingLog;
import racingcargame.domain.RacingResult;
import racingcargame.domain.RepeatTimes;

public class RacingCarController {
	public RacingResult run(String names, RepeatTimes repeatTimes, MoveStrategy moveStrategy) {
		final RacingCars racingCars = new RacingCars(names);
		return processGame(repeatTimes, racingCars, moveStrategy);
	}

	private RacingResult processGame(RepeatTimes repeatTimes, RacingCars racingCars,
		MoveStrategy moveStrategy) {
		List<RacingLog> racingLogs = new ArrayList<>();
		for (int i = 0; i < repeatTimes.getRepeatTimes(); i++) {
			racingLogs.add(racingCars.processOneRace(moveStrategy));
		}
		return new RacingResult(racingLogs);
	}
}
