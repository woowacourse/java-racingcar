package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResult {

	private static final int ADDITIONAL_NUMBER = 1;
	private static final int INIT_VALUE_OF_ATTEMPT_NUMBER = 0;
	private static final String ROUND_RANGE_ERROR = "해당 라운드 결과가 존재하지 않습니다.";

	private final Map<Round, List<Car>> results = new HashMap<>();
	private AttemptNumber attemptNumber = AttemptNumber.of(INIT_VALUE_OF_ATTEMPT_NUMBER);

	public void add(List<Car> cars) {
		int newRound = attemptNumber.value() + ADDITIONAL_NUMBER;
		attemptNumber = AttemptNumber.of(newRound);

		results.put(Round.of(newRound), cars);
	}

	public List<Car> findResult(Round round) {
		checkRangeOfRound(round);

		List<Car> cars = results.get(round);
		return Collections.unmodifiableList(cars);
	}

	private void checkRangeOfRound(Round round) {
		if (!results.containsKey(round)) {
			throw new IllegalArgumentException(ROUND_RANGE_ERROR);
		}
	}
}
