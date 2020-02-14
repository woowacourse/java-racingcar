package tdd.racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InputUtilsTest {
	@Test
	void splitByComma() {
		List<String> actual = InputUtils.splitByComma("a,b,c,d");
		List<String> expected = new ArrayList<>(
				Arrays.asList("a", "b", "c", "d")
		);
		assertThat(actual).isEqualTo(expected);
	}
}
