package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingResult {
	private List<RacingLog> racingResult;

	public RacingResult(List<RacingLog> racingLogs) {
		Objects.requireNonNull(racingLogs);
		this.racingResult = new ArrayList<>(racingLogs);
	}

	public List<String> getWinners() {
		validateSize(racingResult);
		int resultIndex = racingResult.size() - 1;
		RacingLog lastLog = racingResult.get(resultIndex);
		return lastLog.getWinners();
	}

	private void validateSize(List<RacingLog> racingResult) {
		if (racingResult.isEmpty()) {
			throw new IllegalArgumentException("경주 횟수가 적어 결과를 구할 수 없습니다.");
		}
	}

	public List<RacingLog> getRacingResult() {
		return racingResult;
	}
}
