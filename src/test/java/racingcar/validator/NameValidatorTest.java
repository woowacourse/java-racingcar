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
		}).hasMessage("빈 값이 입력되었습니다.");
	}

	@Test
	public void 이름이_공백인_경우() {
		String name = "   ";
		assertThatThrownBy(() -> {
			NameValidator.checkCarName(name);
		}).hasMessage("이름이 공백일 수 없습니다.");
	}

	@Test
	public void 이름이_5자보다_큰_경우() {
		String name = "abcdef";
		assertThatThrownBy(() -> {
			NameValidator.checkCarName(name);
		}).hasMessage("이름이 5자보다 클 수 없습니다.");
	}

	@Test
	public void 이름에_특수문자가_들어간_경우() {
		String name = "주리!";
		assertThatThrownBy(() -> {
			NameValidator.checkCarName(name);
		}).hasMessage("이름에 특수문자를 입력할 수 없습니다. (단, '-' 제외)");
	}

	@Test
	public void 입력된_이름이_하나인_경우() {
		List<String> nameList = new ArrayList<>(Collections.singletonList("prodo"));
		assertThatThrownBy(() -> {
			NameValidator.checkNameList(nameList);
		}).hasMessage("경주할 자동차가 한 대일 경우 경주를 진행할 수 없습니다.");
	}

	@Test
	public void 중복된_이름이_있는_경우() {
		List<String> nameList = new ArrayList<>(Arrays.asList("prodo", "prodo"));
		assertThatThrownBy(() -> {
			NameValidator.checkNameList(nameList);
		}).hasMessage("중복되는 이름이 존재합니다.");
	}
}