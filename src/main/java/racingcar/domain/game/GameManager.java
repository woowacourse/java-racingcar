package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovement;
import racingcar.dto.GameWinnersResponse;
import racingcar.dto.RoundResultResponse;

public class GameManager {
	private final CarMovement carMovement;
	private final Cars cars;
	private GameRound gameRound;

	public GameManager(final CarMovement carMovement, final Cars cars) {
		this.carMovement = carMovement;
		this.cars = cars;
	}

	// Enum 활용
	public RoundResultResponse moveCarsV1() {
		cars.moveCarsV1(carMovement);
		gameRound.nextRound();
		return RoundResultResponse.from(cars.getCars());
	}

	// 전략 패턴
	public RoundResultResponse moveCarsV2() {
		cars.moveCarsV2(carMovement);
		gameRound.nextRound();
		return RoundResultResponse.from(cars.getCars());
	}

	public GameWinnersResponse getGameResult() {
		final Winners winners = new Winners(cars.getCars());
		return GameWinnersResponse.from(winners.getWinnerNames());
	}

	public void setUpCars(final List<String> carNames) {
		final List<Car> createdCars = carNames.stream()
			.map(Car::from)
			.collect(Collectors.toList());
		cars.addCars(createdCars);
	}

	public void setUpGameRound(final int totalGameRound) {
		gameRound = new GameRound(totalGameRound);
	}

	public boolean isGameContinue() {
		return !gameRound.isEnd();
	}
}
