package racingcar.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/16
 */

public class CarsTest {
	private List<Car> inputCars;

	@BeforeEach
	void setUp() {
		inputCars = new ArrayList<>(Arrays.asList(
				new Car("toney", 5),
				new Car("pobi", 8),
				new Car("cozy", 2)
		));
	}

	@Test
	@DisplayName("Car 생성자 테스트")
	void Cars_생성자_정상_케이스_테스트() {
		//when
		Cars cars = new Cars(inputCars);
		//then
		assertThat(cars).isInstanceOf(Cars.class);
	}

	@Test
	@DisplayName("Car 중복 이름시 예외처리 테스트")
	void Cars_중복_이름_있다면_예외처리() {
		//given
		inputCars.add(new Car("pobi"));
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new Cars(inputCars));
	}

	@Test
	@DisplayName("가장 멀리간 자동차의 position 찾는 테스트")
	void findTopCarPosition_가장_멀리간_자동차의_position_찾기() {
		//given
		inputCars.add(new Car("babo", 8));
		//when
		Cars cars = new Cars(inputCars);
		//then
		assertThat(cars.findTopCarPosition()).isEqualTo(8);
	}

}
