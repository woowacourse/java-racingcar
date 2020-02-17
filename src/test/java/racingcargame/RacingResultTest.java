package racingcargame;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.MoveStrategy;
import racingcargame.domain.NumberGenerator;
import racingcargame.domain.RacingLog;
import racingcargame.domain.RacingResult;
import racingcargame.domain.car.Car;

class RacingResultTest {
	private MoveStrategy moveStrategy;
	private RacingResult racingResult;
	private List<RacingLog> racingLogs;

	@BeforeEach
	void setUp() {
		moveStrategy = new NumberGenerator();
		racingLogs = new ArrayList<>();
	}

	@Test
	@DisplayName("생성자 테스트")
	void constructorTest() {
		Assertions.assertThat(new RacingResult(racingLogs)).isInstanceOf(RacingResult.class);
	}

	@Test
	@DisplayName("getWinners 테스트")
	void getWinnersTest() {
		//given
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("car1"));
		cars.add(new Car("car2"));
		cars.add(new Car("car3"));

		cars.get(0).decideMoveOrStop(moveStrategy.getMoveNo());
		cars.get(2).decideMoveOrStop(moveStrategy.getMoveNo());
		racingLogs.add(new RacingLog(cars));

		cars.get(2).decideMoveOrStop(moveStrategy.getMoveNo());
		racingLogs.add(new RacingLog(cars));

		//when
		racingResult = new RacingResult(racingLogs);
		Assertions.assertThat(racingResult.getWinners()).contains("car3");

		cars.get(0).decideMoveOrStop(moveStrategy.getMoveNo());
		racingLogs.add(new RacingLog(cars));

		racingResult = new RacingResult(racingLogs);
		Assertions.assertThat(racingResult.getWinners()).containsExactly("car1", "car3");
	}

	@Test
	@DisplayName("getWinners 실패 테스트")
	void getWinnersFailTest() {
		List<RacingLog> emptyRacingLogs = new ArrayList<>();

		racingResult = new RacingResult(emptyRacingLogs);
		Assertions.assertThatThrownBy(() -> racingResult.getWinners())
			.hasMessage("경주 횟수가 적어 결과를 구할 수 없습니다.");
	}
}
