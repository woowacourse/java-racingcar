package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
	private List<RacingStatus> racingResult;

	public RacingResult(List<RacingStatus> racingResult) {
		this.racingResult = new ArrayList<>(racingResult);
	}

	public List<String> getWinners() {
		RacingStatus lastStatus = racingResult.get(racingResult.size() - 1);
		return lastStatus.getWinners();
	}

	public List<RacingStatus> getRacingResult() {
		return racingResult;
	}
}
