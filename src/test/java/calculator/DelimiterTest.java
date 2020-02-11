package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DelimiterTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	void 구분자반환(String value, String expected) {
		String delimiter = Delimiter.getDelimiter(value);
		assertThat(delimiter).isEqualTo(expected);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("//;\n1;2;3", ";"),
				Arguments.of("1:2,3", ":"));
	}
}
