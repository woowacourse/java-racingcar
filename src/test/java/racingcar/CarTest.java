package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	public void 차_생성() {
		assertThat( new Car("forky").getName()).isEqualTo("forky");
	}

	@Test
	public void 차_여러대_생성() {
		assertThat(CarFactory.of("forky,kun"))
			.containsExactlyInAnyOrder(new Car("forky"), new Car("kun"));
	}

	@Test
	public void 이름_5글자_제한_오류발생() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 공백_이름() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 중복된_이름() {
		assertThatThrownBy(() -> new Cars(CarFactory.of("forky,forky")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}
}
