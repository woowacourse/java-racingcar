package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResult {

	private static final int ADDITIONAL_NUMBER = 1;

	private final Map<Round, List<Car>> results = new HashMap<>();
	private AttemptNumber attemptNumber = AttemptNumber.fromInitValue();

	public void add(List<Car> cars)  {
		int newRound = attemptNumber.value() + ADDITIONAL_NUMBER;
		attemptNumber = AttemptNumber.fromIntegerValue(newRound);

		results.put(Round.of(newRound), cars);
	}

	public List<Car> findResult(Round round) {
		List<Car> cars = results.get(round);
		return new ArrayList<>(cars);
	}
}
