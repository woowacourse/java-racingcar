package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void checkDuplicate_유효한_이름() {
		List<Car> nonDuplicatedCars = new ArrayList<>();
		nonDuplicatedCars.add(new Car(new Name("a")));
		nonDuplicatedCars.add(new Car(new Name("bb")));
		nonDuplicatedCars.add(new Car(new Name("ccc")));

		Cars cars = new Cars(nonDuplicatedCars);

		assertThat(cars.getCars()).isEqualTo(nonDuplicatedCars);
	}

	@Test
	void checkDuplicate_중복된_이름_존재() {
		List<Car> duplicatedCars = new ArrayList<>();
		duplicatedCars.add(new Car(new Name("a")));
		duplicatedCars.add(new Car(new Name("bb")));
		duplicatedCars.add(new Car(new Name("a")));

		assertThatThrownBy(() -> new Cars(duplicatedCars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 이름이 존재합니다.");
	}

}
