package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TimesTest {
	@Test
	void times() throws Exception {
		assertThatThrownBy(() -> {
			new Times("asd");
		}).isInstanceOf(NumberFormatException.class);
		assertThat(new Times("10")).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"-3", "0"})
	void helloWorld(String value) {
		assertThatThrownBy(() -> {
			new Times(value);
		}).isInstanceOf(Exception.class);
	}

	@Test
	void null2() {
		assertThatThrownBy(() -> {
			new Times(null);
		}).isInstanceOf(Exception.class);
	}
}
