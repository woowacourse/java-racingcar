package tdd.racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InputUtilsTest {
	@Test
	void splitByComma() {
		final String input = "a,b,c,d";
		List<String> actual = InputUtils.splitByComma(input);
		List<String> expected = new ArrayList<>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		expected.add("d");
		assertEquals(expected, actual);
	}
}
