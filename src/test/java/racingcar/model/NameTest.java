package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("이름이 공백인 경우")
	public void testNameEmpty() {
		//given
		String name = " ";
		//when
		//then
		assertThatThrownBy(() -> {
			new Name(name);
		}).hasMessage("이름이 공백일 수 없습니다.");
	}

	@Test
	@DisplayName("이름이 5자 이상인 경우")
	public void testNameSizeOverFive() {
		//given
		String name = "주리짱짱짱걸";
		//when
		//then
		assertThatThrownBy(() -> {
			new Name(name);
		}).hasMessage("이름이 5자보다 클 수 없습니다.");
	}

	@Test
	@DisplayName("이름이 5자 이하인 경우")
	public void testNameSizeLowerFive() {
		//given
		String name = "주리짱짱걸";
		//when
		Name testName = new Name(name);
		//then
		assertThat(new Name(name)).isEqualTo(testName);
	}

	@Test
	@DisplayName("이름에 특수문자가 들어간 경우")
	public void testSpatialCharInName() {
		//given
		String name = "*주리*";
		//when
		//then
		assertThatThrownBy(() -> {
			new Name(name);
		}).hasMessage("이름에 특수문자를 입력할 수 없습니다. (단, '_' 제외)");
	}

	@Test
	@DisplayName("이름에 특수문자가 들어간 경우지만 '_'인 경우")
	public void testSpatialCharInNameWithException() {
		//given
		String name = "주_리";
		//when
		//then
		assertThat(new Name(name).getName()).isEqualTo(name);
	}

}