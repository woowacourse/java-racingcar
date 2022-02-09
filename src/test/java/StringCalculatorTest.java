import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stringCalculator.StringCalculator;

public class StringCalculatorTest {
	public StringCalculator stringCalculator = new StringCalculator();

	@Test
	public void 쉼표를_기준으로_구분(){
		String str="1,2";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("1", "2");
	}

	@Test
	public void 콜론를_기준으로_구분(){
		String str="1:2";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("1", "2");
	}

	@Test
	public void 커스텀구분자를_기준으로_구분(){
		String str="1//+\n2+3+4";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("1", "2");
	}

		// @Test
	// void 구분자_없() {
	// 	int actual = StringCalculator.spiltAndSum("1");
	// 	assertThat(actual).isEqualTo(1);
	// }
}
