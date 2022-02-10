package carracing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRacingTest {

	@Test
	@DisplayName("자동차 이름의 길이가 5를 초과하는 경우 에러 발생")
	void validate_자동차이름_길이() {
		assertThatThrownBy(() -> {
			new Car("pobbiii");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름의 길이는 5를 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("자동차 이름의 길이가 1미만인 경우 에러 발생")
	void validate_자동차이름_길이기준_미달() {
			assertThatThrownBy(() -> {
				new Car("");
			}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름의 길이는 최소 한글자 이상이어야 합니다.");
	}

	@Test
	void validate_자동차이름_중복(){
		//given
		//when
		//then
		assertThatThrownBy(()-> {
			Cars cars = new Cars(Arrays.asList(
				new Car("pobi"),
				new Car("east"),
				new Car("peper"),
				new Car("east")
			));
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 중복이 되면 안됩니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void 랜덤값_4이상이면_전진(int randomNumber) {
		//given
		Car car = new Car("pobi");
		//when
		car.move(randomNumber);
		int position = car.getPosition();
		//then
		assertThat(position).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void 랜덤값_4미만이면_멈춤(int randomNumber) {
		//given
		Car car = new Car("pobi");
		int originalPosition = car.getPosition();
		//when
		car.move(randomNumber);
		int changedPosition = car.getPosition();
		//then
		assertThat(changedPosition).isEqualTo(originalPosition);
	}

	@Test
	void 최종우승자_결정_한명() {
		//given
		Car pobiCar = new Car("pobi");
		Car eastCar = new Car("east");
		Car peperCar = new Car("peper");
		pobiCar.move(9);
		eastCar.move(9);
		eastCar.move(9);
		peperCar.move(9);
		peperCar.move(9);
		peperCar.move(9);

		Cars cars = new Cars(Arrays.asList(
			pobiCar, eastCar, peperCar
		));
		//when

		//then
		List<String> winners = cars.getWinners();
		assertThat(winners).contains("peper");
	}

	@Test
	public void 최종우승자_결정_여러명() throws Exception{
		//given
		Car pobiCar = new Car("pobi");
		Car eastCar = new Car("east");
		Car peperCar = new Car("peper");
		pobiCar.move(9);
		eastCar.move(9);
		eastCar.move(9);
		eastCar.move(9);
		peperCar.move(9);
		peperCar.move(9);
		peperCar.move(9);

		Cars cars = new Cars(Arrays.asList(
			pobiCar, eastCar, peperCar
		));
		// when
		// then
		List<String> winners = cars.getWinners();
		assertThat(winners).contains("peper","east");
	}
}
