package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class NameValidatorTest {

	@Test
	public void 빈_문자열_입력된_경우() {
		String inputString = "";
		assertThatThrownBy(() -> {
			NameValidator.checkNull(inputString);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 이름이_공백인_경우() {
		String name = "   ";
		assertThatThrownBy(() -> {
			NameValidator.checkSpace(name);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 이름이_5자보다_큰_경우() {
		String name = "abcdef";
		assertThatThrownBy(() -> {
			NameValidator.checkNameSize(name);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 이름에_특수문자가_들어간_경우() {
		String name = "주리!";
		assertThatThrownBy(() -> {
			NameValidator.checkSpecialChar(name);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 입력된_이름이_하나인_경우() {
		List<String> nameList = new ArrayList<>(Collections.singletonList("prodo"));
		assertThatThrownBy(() -> {
			NameValidator.checkNameIsOne(nameList);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 중복된_이름이_있는_경우() {
		List<String> nameList = new ArrayList<>(Arrays.asList("prodo", "prodo"));
		assertThatThrownBy(() -> {
			NameValidator.checkDuplicatedName(nameList);
		}).isInstanceOf(Exception.class);
	}
}