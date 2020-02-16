package racingcargame.controller;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.MoveDecider;
import racingcargame.domain.RepeatTimes;
import racingcargame.domain.RacingCars;
import racingcargame.domain.RacingResult;
import racingcargame.domain.RacingStatus;

public class RacingCarController {
	public RacingResult run(String names, RepeatTimes repeatTimes) {
		final RacingCars racingCars = new RacingCars(names);
		final MoveDecider moveDecider = new MoveDecider();

		return processGame(repeatTimes, racingCars, moveDecider);
	}

	private RacingResult processGame(RepeatTimes repeatTimes, RacingCars racingCars, MoveDecider moveDecider) {
		List<RacingStatus> racingStatuses = new ArrayList<>();
		for (int i = 0; i < repeatTimes.getRepeatTimes(); i++) {
			racingStatuses.add(racingCars.processOneRace(moveDecider));
		}
		return new RacingResult(racingStatuses);
	}
}
