package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.validator.Validator;

public class ValidatorTest {

	private static final String EMPTY_CAR_NAME = "";
	private static final String DUPLICATED_NAME = "pobi";
	private static final String LONG_NAME = "longlongcars";

	@Test
	@DisplayName("자동차가 한개일 때 예외 처리")
	public void validateCountOfCarTest() {
		List<String> carNameBucket = new ArrayList<>(Arrays.asList("pobi"));
		RacingCars racingCars = new RacingCars(carNameBucket);
		assertThatThrownBy(() -> Validator.validateCountOfCar(racingCars)).isInstanceOf(IllegalArgumentException.class);

	}


	@Test
	@DisplayName("중복되는 자동차 이름이 있으면 예외처리")
	public void validateDuplicatedNameTest() {

		List<String> carNameBucket = new ArrayList<>(Arrays.asList(DUPLICATED_NAME, "pobi"));
		RacingCars racingCars = new RacingCars(carNameBucket);

		assertThatThrownBy(() -> Validator.validateDuplicatedName(racingCars)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("유저 인풋이 ',' 로 끝나면 예외 처리")
	public void validateHaveLastInputCommaTest() {
		String userInput = "phobi,json,";

		assertThatThrownBy(() -> Validator.validateHaveLastInputComma(userInput)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도 회수가 자연수가 아니면 예외처리")
	public void validateTryCountIsNaturalNumberTest() {
		String tryCountInput = "0";
		assertThatThrownBy(() -> Validator.validateTryCountIsNaturalNumber(tryCountInput)).isInstanceOf(IllegalArgumentException.class);
	}
}
