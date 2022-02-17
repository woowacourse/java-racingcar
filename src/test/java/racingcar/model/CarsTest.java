package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	Cars cars = new Cars(new ArrayList<>());

	@Test
	@DisplayName("빈 값이 입력된 경우")
	public void testNullInput() {
		//given
		String input = "";
		//when

		//then
		assertThatThrownBy(() -> {
			cars.saveCars(input);
		}).hasMessage("빈 값이 입력되었습니다.");
	}

	@Test
	@DisplayName("자동차가 하나인 경우")
	public void testCarsSizeIsOne() {
		//given
		String input = "judy";
		//when

		//then
		assertThatThrownBy(() -> {
			cars.saveCars(input);
		}).hasMessage("경주할 자동차가 한 대일 경우 경주를 진행할 수 없습니다.");
	}

	@Test
	@DisplayName("자동차의 이름이 중복된 경우")
	public void findDuplicationCarSTest() {
		//given
		String input = "judy,judy";
		//when

		//then
		assertThatThrownBy(() -> {
			cars.saveCars(input);
		}).hasMessage("중복되는 이름이 존재합니다.");
	}

}