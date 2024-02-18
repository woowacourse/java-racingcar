package domain.strategy;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberMovingStrategyTest {

	RandomNumberMovingStrategy movingStrategy = new RandomNumberMovingStrategy();

	@DisplayName("4 이상의 숫자일때 차량 이동 허용 확인")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void isGreaterThanMovingNumber_WithNumbersCanMove(int number) throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {
		boolean result = (boolean)isGreaterThanMovingNumber().invoke(movingStrategy, number);
		assertThat(result).isTrue();
	}

	@DisplayName("4 미만의 숫자일때 차량 이동 금지 확인")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void isGreaterThanMovingNumber_WithNumbersCannotMove(int number) throws
		NoSuchMethodException,
		InvocationTargetException,
		IllegalAccessException {
		boolean result = (boolean)isGreaterThanMovingNumber().invoke(movingStrategy, number);
		assertThat(result).isFalse();
	}

	@DisplayName("0부터 9까지가 아닌 숫자에 대한 예외 발생 확인")
	@ParameterizedTest
	@ValueSource(ints = {-1, 10})
	void isGreaterThanMovingNumber_WithNumbersThrowsException(int number) {
		assertThatThrownBy(() -> {
			isGreaterThanMovingNumber().invoke(movingStrategy, number);
		}).isInstanceOf(InvocationTargetException.class);
	}

	private Method isGreaterThanMovingNumber() throws NoSuchMethodException {
		Method method = RandomNumberMovingStrategy.class.getDeclaredMethod("isGraterThanMovingNumber", int.class);
		method.setAccessible(true);

		return method;
	}
}