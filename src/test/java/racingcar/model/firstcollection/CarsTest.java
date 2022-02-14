package racingcar.model.firstcollection;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import racingcar.model.vo.Car;

public class CarsTest {
	@ParameterizedTest(name = "new Cars({0})")
	@NullAndEmptySource
	@DisplayName("new Cars()에 Null, Empty 전달 시 IAE발생")
	void validateNullOrEmpty(List<Car> cars) {
		assertThatThrownBy(() -> new Cars(cars))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageMatching("자동차 목록을 확인해주세요");
	}

}
