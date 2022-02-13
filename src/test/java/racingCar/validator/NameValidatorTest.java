package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingCar.utlis.Constants;

class NameValidatorTest {

	@Test
	public void 빈_문자열_입력된_경우() {
		String inputString = "";
		assertThatThrownBy(() -> {
			NameValidator.validateInput(inputString);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_NULL_MESSAGE);
	}

	@Test
	public void 이름이_공백인_경우() {
		String name = "   ";
		assertThatThrownBy(() -> {
			NameValidator.validateName(name);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_SPACE_MESSAGE);
	}

	@Test
	public void 이름이_5자보다_큰_경우() {
		String name = "abcdef";
		assertThatThrownBy(() -> {
			NameValidator.validateName(name);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_NAME_RANGE);
	}

	@Test
	public void 이름에_특수문자가_들어간_경우() {
		String name = "주리!";
		assertThatThrownBy(() -> {
			NameValidator.validateName(name);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_SPACIAL_MESSAGE);
	}

	@Test
	public void 입력된_이름이_하나인_경우() {
		List<String> nameList = new ArrayList<>(List.of("prodo"));
		assertThatThrownBy(() -> {
			NameValidator.validateNameList(nameList);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_ONE_NAME_MESSAGE);
	}

	@Test
	public void 중복된_이름이_있는_경우() {
		List<String> nameList = new ArrayList<>(Arrays.asList("prodo", "prodo"));
		assertThatThrownBy(() -> {
			NameValidator.validateNameList(nameList);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_DUPLICATED_NAME_MESSAGE);
	}
}