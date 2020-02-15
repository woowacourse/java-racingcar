package com.woowacourse.racingGame.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Name;
import com.woowacourse.racingGame.domain.Position;

@SuppressWarnings("NonAsciiCharacters")
public class StringUtilTest {
	@Test
	void split_쉼표로_구분되어_입력된_자동차_이름() {
		final String inputCarName = "a,b,c,d";

		List<String> actual = StringUtil.split(inputCarName);

		List<String> expected = Arrays.asList("a", "b", "c", "d");

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void split_공백이_앞뒤로_존재하는_자동차_이름() {
		final String inputCarName = "a, b, c, d ";

		List<String> actual = StringUtil.split(inputCarName);

		List<String> expected = Arrays.asList("a", "b", "c", "d");

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void convertIntoDashBy_게임을_진행한_자동차의_상태() {
		final Car car = new Car(new Name("test"), Position.valueOf(4));

		final String actual = StringUtil.convertIntoDashBy(car.getPosition());

		final String expected = "----";

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void joinNameOf_우승한_자동차_이름들() {
		final List<String> winners = Arrays.asList("toni", "alt");

		final String actual = StringUtil.joinNameOf(winners);

		final String expected = "toni, alt";

		assertThat(actual).isEqualTo(expected);
	}
}
