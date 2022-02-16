package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.strategy.MoveStrategy;

public class GameTest {
	@Test
	@DisplayName("무조건 false를 반환하는 MoveStrategy 일 때 Car 이동")
	public void play_MoveStrategy_false() {
		TestCars cars = new TestCars();
		new Game(cars).play(() -> false);
		cars.getCars()
			.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
	}

	@Test
	@DisplayName("무조건 true를 반환하는 MoveStrategy 일 때 Car 이동")
	public void play_MoveStrategy_true() {
		TestCars cars = new TestCars();
		new Game(cars).play(() -> true);
		cars.getCars()
			.forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
	}

	@Test
	@DisplayName("우승자가 한 명일 때 우승자 판정")
	public void getWinners_one_winner() {
		TestCars cars = new TestCars();
		Game game = new Game(cars);
		game.play(moveOnce);
		assertThat(game.getWinners())
			.containsExactly(cars.getCars().get(0));
	}

	@Test
	@DisplayName("우승자가 두 명일 때 우승자 판정")
	public void getWinners_two_winners() {
		TestCars cars = new TestCars();
		Game game = new Game(cars);
		game.play(moveTwice);
		assertThat(game.getWinners())
			.containsExactlyInAnyOrder(cars.getCars().get(0), cars.getCars().get(1));
	}

	class TestCars implements Cars {
		private final List<Car> cars;

		public TestCars() {
			this.cars = List.of(
				new Car("forky"),
				new Car("kun"),
				new Car("pobi")
			);
		}

		@Override
		public List<Car> getCars() {
			return cars;
		}

		@Override
		public List<Car> getCarsInPosition(int position) {
			return cars.stream()
				.filter(car -> car.isPosition(position))
				.collect(Collectors.toList());
		}

		@Override
		public int getMaxPosition() {
			return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.getAsInt();
		}
	}

	private MoveStrategy moveOnce = new MoveStrategy() {
		private int count = 0;

		@Override
		public boolean isMovable() {
			if (count > 0) {
				return false;
			}
			count++;
			return true;
		}
	};

	private MoveStrategy moveTwice = new MoveStrategy() {
		private int count = 0;

		@Override
		public boolean isMovable() {
			if (count > 1) {
				return false;
			}
			count++;
			return true;
		}
	};
}
