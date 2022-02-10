package carracing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	// private List<Car> cars;
	// public Cars(List<Car> cars){
	// 	this.cars = cars;
	// }
}