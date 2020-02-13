package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.WinningRule;

/**
 * 승리 결정 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class WinningRuleTest {
	private Cars cars;

	@BeforeEach
	void initialize() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car(new Name("pobi"), new Position(2)));
		carList.add(new Car(new Name("alt"), new Position(3)));
		carList.add(new Car(new Name("habi"), new Position(4)));
		carList.add(new Car(new Name("honux"), new Position(5)));
		carList.add(new Car(new Name("tony"), new Position(6)));
		carList.add(new Car(new Name("sth"), new Position(6)));
		cars = new Cars(carList);
	}

	@Test
	@DisplayName("승자 정하는 테스트")
	void decideWinner() {
		List<Name> winnerNames = Arrays.asList(new Name("tony"), new Name("sth"));
		WinningRule winningRule = cars.getWinningRule();
		Assertions.assertThat(winningRule.decideWinners())
				.isEqualTo(winnerNames);
	}
}
