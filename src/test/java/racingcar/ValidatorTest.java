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

	private RacingCar racingCar1;

	@BeforeEach
	public void setUp() {
		racingCar1 = RacingCar.generateRacingCar("pobi");
	}

	@Test
	@DisplayName("자동차가 한개일 때 예외 처리")
	public void validateCountOfCarTest() {

		RacingCars racingCars = new RacingCars(List.of(racingCar1));
		assertThatThrownBy(() -> Validator.validateCountOfCar(racingCars)).isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	@DisplayName("자동차 이름 빈칸일 때 예외처리")
	public void validateCarNameIsEmptyTest() {

		RacingCar noNameCar = RacingCar.generateRacingCar(EMPTY_CAR_NAME);
		RacingCars racingCars = new RacingCars(List.of(noNameCar, racingCar1));
		assertThatThrownBy(() -> Validator.validateCarsNameIsEmpty(racingCars)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 6자 이상일때 예외처리")
	public void validateCarNameSizeTest() {

		RacingCar longNameCar = RacingCar.generateRacingCar(LONG_NAME);
		RacingCars racingCars = new RacingCars(List.of(longNameCar, racingCar1));

		assertThatThrownBy(() -> Validator.validateCarsNameSize(racingCars)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("중복되는 자동차 이름이 있으면 예외처리")
	public void validateDuplicatedNameTest() {

		RacingCar duplicatedNameCar = RacingCar.generateRacingCar(DUPLICATED_NAME);
		RacingCars racingCars = new RacingCars(List.of(duplicatedNameCar, racingCar1));

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
