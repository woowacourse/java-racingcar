package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	void split() {
		String actual = "1,2";
		assertThat(actual.split(",")).contains("1", "2");
	}

	@Test
	void substring() {
		String actual = "(1,2)";
		assertThat(actual.substring(1, 4)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("String index 범위 테스트")
	void stringIndexOfTest() {
		String actual = "abc";
		assertThatThrownBy(() ->{
			actual.charAt(4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}



/*
* 요구사항 1
* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
*
* 요구사항 2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
* */