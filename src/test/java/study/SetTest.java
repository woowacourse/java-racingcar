package study;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("해당 값이 포함되어 있는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void contains(int input) {
		assertTrue(numbers.contains(input));
	}

	@DisplayName("포함 여부를 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void hasValue(int input, boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}
}
