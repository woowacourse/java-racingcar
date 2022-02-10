import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stringCalculator.StringCalculator;

public class StringCalculatorTest {
	public StringCalculator stringCalculator = new StringCalculator();

	@Test
	public void 쉼표를_기준으로_구분() {
		String str = "1,2";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("1", "2");
	}

	@Test
	public void 콜론를_기준으로_구분() {
		String str = "1:2";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("1", "2");
	}

	@Test
	public void 커스텀구분자를_기준으로_구분() {
		String str = "//a\n2a3a4";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("2", "3", "4");
	}
	@Test
	public void 파라미터가_숫자가_아닌경우(){
		String str = "1,2,a";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThatThrownBy(() -> {
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 구분자_앞에_아무것도_없는경우(){
		String str = ",,1,2";
		assertThatThrownBy(() -> {
			String[] splitStringArray = stringCalculator.splitString(str);
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 구분자_뒤에_아무것도_없는경우(){
		String str = "1,2,,,";
		assertThatThrownBy(() -> {
			String[] splitStringArray = stringCalculator.splitString(str);
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 구분자_중간에_아무것도_없는경우(){
		String str = "1,;2";
		assertThatThrownBy(() -> {
			String[] splitStringArray = stringCalculator.splitString(str);
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 구분자_뒤에_아무것도_없는경우_커스텀구분자_포함(){
		String str = "\\!\n1,2!!";
		assertThatThrownBy(() -> {
			String[] splitStringArray = stringCalculator.splitString(str);
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 구분자_중간에_아무것도_없는경우_커스텀구분자_포함(){
		String str = "\\!\n1!!2";
		assertThatThrownBy(() -> {
			String[] splitStringArray = stringCalculator.splitString(str);
			int sumResult = stringCalculator.sumString(splitStringArray);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void 빈문자_입력(){
		String str = "";
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("0");
	}

	@Test
	public void null_입력(){
		String str = null;
		String[] splitStringArray = stringCalculator.splitString(str);
		assertThat(splitStringArray).contains("0");
	}

	/*
	*
	* assertThatThrownBy(() -> {
    // ...
}).isInstanceOf(IndexOutOfBoundsException.class)
  .hasMessageContaining("Index: 2, Size: 2");*/

}
