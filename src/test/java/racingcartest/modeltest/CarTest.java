package racingcartest.modeltest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class CarTest {

	@DisplayName("이름이 null일 경우 예외가 발생한다")
	@Test
	public void carNameTest_null() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Car(null);
		});
	}

	@DisplayName("이름이 공백일 경우 예외가 발생한다")
	@Test
	public void carNameTest_blank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Car("");
		});
	}

	@DisplayName("이름이 5글자 이상일 경우 예외가 발생한다")
	@Test
	public void carNameTest_length() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Car("abcdef");
		});
	}

	@DisplayName("이름에 특수기호가 들어간 경우 예외가 발생한다")
	@Test
	public void carNameTest_specialSymbol() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Car("car!!");
		});
	}

}
