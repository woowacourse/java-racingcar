package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void splitStringByCommaWithMultipleValues_Success() {
		String[] splitted = "1,2".split(",");
		assertThat(splitted).containsExactly("1", "2");
	}

	@Test
	void splitStringByCommaWithSingleValue_Success() {
		String[] splitted = "1".split(",");
		assertThat(splitted).contains("1");
	}

}
