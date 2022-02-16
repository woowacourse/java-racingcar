package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingResult {

	private final HashMap<Round, List<Car>> results = new HashMap<>();
	private AttemptNumber attemptNumber = AttemptNumber.fromIntegerValue(0);

	public void add(List<Car> cars)  {
		int newRound = attemptNumber.value() + 1;
		attemptNumber = AttemptNumber.fromIntegerValue(newRound);

		results.put(Round.of(newRound), cars);
	}

	public List<Car> findResult(Round round) {
		List<Car> cars = results.get(round);
		return new ArrayList<>(cars);
	}
}
