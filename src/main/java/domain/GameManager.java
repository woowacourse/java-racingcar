package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
	private static final int RANDOM_BOUND = 10;
	private static final String ATTEMPT_NO_EXCESS = "실행 횟수를 초과하였습니다.";

	private final Random random;
	private final Cars cars;
	private final AttemptNo attemptNo;

	public GameManager(String carNames, String attemptNumber) {
		this.cars = new Cars(CarGenerator.create(carNames));
		this.attemptNo = new AttemptNo(attemptNumber);
		this.random = new Random();
	}

	public RacingResults race() {
		if (attemptNo.execute()) {
			List<RacingResult> results = new ArrayList<>();
			int carsSize = cars.getSize();
			for (int count = 0; count < carsSize; count++) {
				RacingResult racingResult = cars.moveByIndex(count, new RandomNo(getRandomNumber()));
				results.add(racingResult);
			}
			return new RacingResults(results);
		}
		throw new IllegalArgumentException(ATTEMPT_NO_EXCESS);
	}

	public Cars findWinners() {
		int maxPosition = cars.getMaxPosition();
		List<Car> winners = cars.findByPosition(maxPosition);
		return new Cars(winners);
	}

	private int getRandomNumber() {
		return random.nextInt(RANDOM_BOUND);
	}

	public boolean isEnd() {
		return attemptNo.isEnd();
	}
}
