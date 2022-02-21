package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utlis.Convertor;

class CarsTest {

	Cars cars;

	@Test
	@DisplayName("자동차가 하나인 경우")
	public void testCarsSizeIsOne() {
		//given
		String input = "judy";
		//when
		List<String> inputNames = Arrays.asList(Convertor.separateNamesByDelimiter(input));
		//then
		assertThatThrownBy(() -> {
			cars = Cars.from(inputNames);
		}).hasMessage("경주할 자동차가 한 대 이하일 경우 경주를 진행할 수 없습니다.");
	}

	@Test
	@DisplayName("자동차의 이름이 중복된 경우")
	public void findDuplicationCarSTest() {
		//given
		String input = "judy,judy";
		//when
		List<String> inputNames = Arrays.asList(Convertor.separateNamesByDelimiter(input));
		//then
		assertThatThrownBy(() -> {
			cars = Cars.from(inputNames);
		}).hasMessage("중복되는 이름이 존재합니다.");
	}

}