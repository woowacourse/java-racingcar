package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RefereeTest {
	@Test
	public void 차_전진_판단() {
		Car car = new Car("kun");
		Referee.moveCar(car, 5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void 우승자_판정() {
		Set<Car> cars = new HashSet<>();
		Car car1 = new Car("forky");
		Car car2 = new Car("kun");
		car1.move();
		cars.add(car1);
		cars.add(car2);
		assertThat(Referee.judgeWinner(cars)).contains(car1);
	}

	@Test
	public void 우승자_여러명() {
		Car winner1 = new Car("pobi");
		Car winner2 = new Car("kun");
		Car loser = new Car("forky");
		winner1.move();
		winner2.move();
		assertThat(Referee.judgeWinner(Set.of(winner1, winner2, loser))).containsExactlyInAnyOrder(winner1, winner2);
	}
}
