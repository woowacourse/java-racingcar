package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class InputViewTest {
	@Test
	public void splitAsCommaTest(){
		String value = "A,B,C";
		List<String> result = InputView.splitAsComma(value);

		assertThat(result).contains("A");
		assertThat(result).contains("B");
		assertThat(result).contains("C");
	}
}
