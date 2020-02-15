package racingcargame.controller;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.CarStatus;
import racingcargame.domain.MoveDecider;
import racingcargame.domain.RacingCars;
import racingcargame.domain.RepeatTimes;

public class RacingCarController {

	public List<String> winners;

	public List<CarStatus> run(String inputName, RepeatTimes inputRepeat) {
		final RacingCars racingCars = new RacingCars(inputName);
		final MoveDecider moveDecider = new MoveDecider();

		final List<CarStatus> racingResult = processGame(inputRepeat, racingCars, moveDecider);
		winners = rankGame(racingCars);
		return racingResult;
	}

	private List<CarStatus> processGame(RepeatTimes repeatTimes, RacingCars racingCars, MoveDecider moveDecider) {
		List<CarStatus> racingResult = new ArrayList<>();
		for (int i = 0; i < repeatTimes.getRepeatTimes(); i++) {
			racingResult.add(racingCars.processOneRace(moveDecider));
		}
		return racingResult;
	}

	private List<String> rankGame(RacingCars racingCars) {
		return racingCars.getWinners();
	}
}
