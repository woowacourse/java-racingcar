package racingcargame.controller;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.MoveDecider;
import racingcargame.domain.RacingCars;
import racingcargame.domain.RacingResult;
import racingcargame.domain.RacingStatus;
import racingcargame.domain.RepeatTimes;

public class RacingCarController {

	public RacingResult run(String inputName, RepeatTimes inputRepeat) {
		final RacingCars racingCars = new RacingCars(inputName);
		final MoveDecider moveDecider = new MoveDecider();

		return processGame(inputRepeat, racingCars, moveDecider);
	}

	private RacingResult processGame(RepeatTimes repeatTimes, RacingCars racingCars, MoveDecider moveDecider) {
		List<RacingStatus> racingStatuses = new ArrayList<>();
		for (int i = 0; i < repeatTimes.getRepeatTimes(); i++) {
			racingStatuses.add(racingCars.processOneRace(moveDecider));
		}
		return new RacingResult(racingStatuses);
	}
}
